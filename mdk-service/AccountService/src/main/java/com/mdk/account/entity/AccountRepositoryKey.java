package com.mdk.account.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder(toBuilder = true)
@Embeddable
@EqualsAndHashCode
public class AccountRepositoryKey implements Serializable {


    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name="account_id")
    private Long accountId;

    //@Id
    @Column(name="account_number")
    private Long accountNumber;

}
