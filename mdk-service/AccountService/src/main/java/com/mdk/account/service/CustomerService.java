package com.mdk.account.service;

import com.mdk.account.dto.AccountDto;
import com.mdk.account.dto.CustomerDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CustomerService {

    public void createCustomerAccount(CustomerDto customerDto);


    CustomerDto getCustomerByPhoneNumber(String phoneNumber);
}
