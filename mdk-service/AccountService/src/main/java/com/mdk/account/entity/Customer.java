package com.mdk.account.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="customer") // This class is mapped to the table named customer
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Customer extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="customer_id")
    private Long customerId;

    @Column(name="name")
    private String name;

    @Column(name="email")
    private String email;

    @Column(name="mobile_number")
    private String mobileNumber;

    //	@Enumerated(EnumType.STRING)
    //	private Gender gender;
    /*
    public enum Gender {
	MALE,
	FEMALE
}
     */
}
