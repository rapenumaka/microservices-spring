package com.mdk.app.mapper;

import com.mdk.app.dto.LoanDto;
import com.mdk.app.entity.Loan;

public class LoanMapper {


    public static Loan mapToLoan(LoanDto loneDto){
      Loan loan = new Loan();
      loan.setLoanAmount(loneDto.getLoanAmount());
      loan.setLoanNumber(loneDto.getLoanNumber());
      loan.setPhoneNumber(loneDto.getPhoneNumber());
      loan.setLoanBalance(loneDto.getLoanBalance());
      return loan;
    }

    public static LoanDto mapToLoanDto(Loan loan){
        LoanDto loanDto = new LoanDto();
        loanDto.setLoanAmount(loan.getLoanAmount());
        loanDto.setLoanBalance(loan.getLoanBalance());
        loanDto.setPhoneNumber(formatPhoneNumber(loan.getPhoneNumber()));
        loanDto.setLoanNumber(loan.getLoanNumber());
        return loanDto;
    }

    public static String formatPhoneNumber(String phonenumber){

        if(phonenumber.trim().length()==10){
            return String.format("%s-%s-%s",phonenumber.substring(0,3),phonenumber.substring(3,6), phonenumber.substring(6,10));
        }else{
            return phonenumber;
        }

    }

}
