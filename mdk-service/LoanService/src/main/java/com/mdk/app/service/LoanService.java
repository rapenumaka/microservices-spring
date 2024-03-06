package com.mdk.app.service;

import com.mdk.app.dto.LoanDto;

import java.math.BigDecimal;
import java.util.List;

public interface LoanService {

    public LoanDto findbyPhoneNumber(String phoneNumber);

    public LoanDto findbyLoanNumber(String loanNumber);

    public List<LoanDto> getAllLoans();

    public LoanDto createLoan(String phoneNumber, BigDecimal loanAmount);

    public LoanDto updateLoan(String phoneNumber, BigDecimal installment);

    public boolean deleteLoan(String phoneNumber);

}
