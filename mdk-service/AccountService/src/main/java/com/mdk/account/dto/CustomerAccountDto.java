package com.mdk.account.dto;

import com.mdk.account.entity.AccountType;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class CustomerAccountDto {

    @NotEmpty(message = "Name cannot be null")
    private String name;

    @NotEmpty
    @Email
    private String email;

    @NotEmpty(message = "Name cannot be null")
    @Pattern(regexp="(^$|[0-9]{10})",message = "Mobile Number must be 10 digits")
    private String mobileNumber;

    @NotEmpty
    private AccountType accountType;

    @NotEmpty
    private String city;






}
