package com.mdk.app.service.impl;

import com.mdk.app.exception.LoanWithPhoneNumberAlreadyExistsException;
import com.mdk.app.mapper.LoanMapper;
import com.mdk.app.dto.LoanDto;
import com.mdk.app.entity.Loan;
import com.mdk.app.exception.LoanNotFoundException;
import com.mdk.app.repository.LoanRepository;
import com.mdk.app.service.LoanService;
import com.mdk.app.utils.LoanNumberGenerator;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class LoanServiceImpl implements LoanService {

    private LoanRepository loanRepository;



    @Override
    public LoanDto findbyPhoneNumber(String phoneNumber) {
        Optional<Loan> loan = loanRepository.findByPhoneNumber(phoneNumber);
       if(loan.isPresent()){
           return LoanMapper.mapToLoanDto(loan.get());
       }else{
           throw new LoanNotFoundException(phoneNumber);
       }
    }

    @Override
    public LoanDto findbyLoanNumber(String loanNumber) {
        Optional<Loan> loan = loanRepository.findByLoanNumber(loanNumber);
        if(loan.isPresent()){
            return LoanMapper.mapToLoanDto(loan.get());
        }else{
            throw new LoanNotFoundException(loanNumber);
        }
    }

    @Override
    public List<LoanDto> getAllLoans() {
        List<Loan> loans = loanRepository.findAll();

        Set<Loan> loansSet =loans.stream().sorted(Comparator.comparing(Loan::getLoanNumber).thenComparing(Loan::getLoanAmount)).collect(Collectors.toSet());

        return loans.stream().peek(e -> System.out.println(e.getLoanNumber())).map(loan -> LoanMapper.mapToLoanDto(loan)).collect(Collectors.toList());
    }

    @Override
    public LoanDto createLoan(String phoneNumber, BigDecimal loanAmount) {

        Optional<Loan> loan = loanRepository.findByPhoneNumber(phoneNumber);
        if(loan.isPresent()){
            throw new LoanWithPhoneNumberAlreadyExistsException(phoneNumber);
        }
        LoanDto loanDto = new LoanDto();
        loanDto.setLoanNumber(LoanNumberGenerator.generate());
        loanDto.setLoanBalance(BigDecimal.ZERO);
        loanDto.setPhoneNumber(phoneNumber);
        loanDto.setLoanAmount(loanAmount);

        this.loanRepository.save(LoanMapper.mapToLoan(loanDto));

        return loanDto;
    }

    @Override
    public LoanDto updateLoan(String phoneNumber, BigDecimal installment) {
        Optional<Loan>  loan = this.loanRepository.findByPhoneNumber(phoneNumber);
        if(loan.isPresent()){
            LoanDto loanDto= LoanMapper.mapToLoanDto(loan.get());
            BigDecimal remaining = loanDto.getLoanAmount().subtract(installment);
            loanDto.setLoanBalance(remaining);
            Loan loan1 = LoanMapper.mapToLoan(loanDto);
            this.loanRepository.save(loan1);

            return loanDto;
        }
        throw new LoanNotFoundException(phoneNumber);
    }

    @Override
    public boolean deleteLoan(String phoneNumber) {


        Optional<Loan> loan = loanRepository.findByPhoneNumber(phoneNumber);
        if(loan.isPresent()){
           this.loanRepository.delete(loan.get());
           return true;
        }else{
            throw new LoanNotFoundException(phoneNumber);
        }
    }
}
