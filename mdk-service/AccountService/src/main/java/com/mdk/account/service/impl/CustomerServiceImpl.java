package com.mdk.account.service.impl;

import com.mdk.account.dto.AccountDto;
import com.mdk.account.dto.CustomerDto;
import com.mdk.account.entity.Account;
import com.mdk.account.entity.AccountType;
import com.mdk.account.entity.Customer;
import com.mdk.account.exception.CustomerAlreadyExistsException;
import com.mdk.account.exception.ResourceNotFoundException;
import com.mdk.account.mapper.AccountMapper;
import com.mdk.account.mapper.CustomerMapper;
import com.mdk.account.repository.AccountRepository;
import com.mdk.account.repository.CustomerRepository;
import com.mdk.account.service.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Random;
@Service
@AllArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private CustomerRepository customerRepository;

    private AccountRepository accountRepository;




    @Override
    public void createCustomerAccount(CustomerDto customerDto) {
        Customer customer = CustomerMapper.mapToCustomer(customerDto, new Customer());
        Optional<Customer> customerInDb = customerRepository.findByMobileNumber(customer.getMobileNumber());
        if(customerInDb.isPresent()){
            throw new CustomerAlreadyExistsException("Customer already exists exception");
        }

        Customer savedCustomer = customerRepository.save(customer);

        Account account = accountRepository.save(createNewAccount(customerDto,savedCustomer));




    }

    @Override
    public CustomerDto getCustomerByPhoneNumber(String phoneNumber) {
        Optional<Customer> byMobileNumber = this.customerRepository.findByMobileNumber(phoneNumber);
        if(byMobileNumber.isPresent()){
            return CustomerMapper.mapToCustomerDto(byMobileNumber.get(), new CustomerDto());
        }else{
            throw new ResourceNotFoundException(phoneNumber, "phone", phoneNumber);
        }
    }


    private Account createNewAccount(CustomerDto customerDto, Customer savedCustomer){
        AccountType accountType  = customerDto.getAccountType() ;
        long randomAccNumber = 1000000000L + new Random().nextInt(900000000); //Create unique 10 digit account number
        AccountDto accountDto = new AccountDto();
        accountDto.setCity(customerDto.getCity());
        accountDto.setAccountNumber(randomAccNumber);
        accountDto.setAccountType(accountType);
        accountDto.setCustomerId(savedCustomer.getCustomerId());

        return AccountMapper.mapToAccounts(accountDto, new Account());


    }
}
