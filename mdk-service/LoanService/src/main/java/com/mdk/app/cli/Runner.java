package com.mdk.app.cli;

import com.mdk.app.service.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class Runner implements CommandLineRunner {


    @Autowired
    private LoanService loanService;
    @Override
    public void run(String... args) throws Exception {

        loanService.createLoan("5551234567", BigDecimal.valueOf(1524.25));
        loanService.createLoan("5559876543", BigDecimal.valueOf(8585.25));
        loanService.createLoan("5555678901", BigDecimal.valueOf(292.25));
        loanService.createLoan("5552345678", BigDecimal.valueOf(2522.23));
        loanService.createLoan("5558765432", BigDecimal.valueOf(8955.20));
        loanService.createLoan("5551231235", BigDecimal.valueOf(895.25));
        loanService.createLoan("5552447059", BigDecimal.valueOf(782.52));
        loanService.createLoan("5552847059", BigDecimal.valueOf(3851.82));


    }
}
