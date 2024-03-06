package com.mdk.app.repository;

import com.mdk.app.entity.Loan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LoanRepository extends JpaRepository<Loan,Long> {

    public Optional<Loan> findByPhoneNumber(String phoneNumber);

    public Optional<Loan> findByLoanNumber(String loanNumber);
}
