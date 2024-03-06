package com.mdk.app.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;


@Entity
@Table(name="loan") // This class is mapped to the table named customer
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Loan extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long loanId;

    @Column(name = "phone-number")
    private String phoneNumber;

    @Column(name = "loan-number")
    private String loanNumber;

    @Column(name = "loan-amount")
    private BigDecimal loanAmount;

    @Column(name = "loan-balance")
    private BigDecimal loanBalance;
}
