package com.mdk.card.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Table(name="loan") // This class is mapped to the table named customer
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Card extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cardId;

    @Column(name = "phone-number")
    private String phoneNumber;

    @Column(name = "card-number")
    private String cardNumber;

    @Column(name = "card-limit")
    private BigDecimal limit;

    @Column(name = "card-balance")
    private BigDecimal cardBalance;


}
