package com.mdk.account.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="account") // This class is mapped to the table named customer
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
//@IdClass(AccountRepositoryKey.class)
public class Account extends BaseEntity {


    /*
        @Id
        @GeneratedValue(strategy = GenerationType.SEQUENCE) //oracle doesn't support identity
        @Column(name="account_id")
        private Long accountId;

            @Id
    @Column(name="account_number")
    private Long accountNumber;

        */
    @EmbeddedId
    private AccountRepositoryKey accountRepositoryKey;

    @Column(name="customer_id")
    private Long customerId;



    @Column(name="account_type")
    @Enumerated(EnumType.STRING)
    private AccountType accountType;

    @Column(name="city")
    private String city;

}
