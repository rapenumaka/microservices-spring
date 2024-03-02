package com.mdk.account.service;

import com.mdk.account.dto.AccountDto;

import java.util.List;

public interface AccountService {


    public void createAccount(AccountDto accountDto);

    public void getAccountByAccountNumber(Long accountNo);

    public void deleteAccount(Long accountNo);

    public  AccountDto updateAccount(AccountDto accountDto);

    public List<AccountDto> getAllAccounts();

}
