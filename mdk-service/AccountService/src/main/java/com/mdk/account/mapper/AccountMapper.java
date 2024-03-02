package com.mdk.account.mapper;

import com.mdk.account.dto.AccountDto;
import com.mdk.account.entity.Account;
import com.mdk.account.entity.AccountRepositoryKey;

public class AccountMapper {

    public static AccountDto mapToAccountsDto(Account account, AccountDto accountsDto) {
        accountsDto.setAccountNumber(account.getAccountRepositoryKey().getAccountNumber());
        accountsDto.setAccountType(account.getAccountType());
        accountsDto.setCity(account.getCity());
        accountsDto.setCustomerId(account.getCustomerId());
        return accountsDto;
    }

    public static Account mapToAccounts(AccountDto accountsDto, Account accounts) {
        accounts.setAccountRepositoryKey(new AccountRepositoryKey().toBuilder().accountNumber(accountsDto.getAccountNumber()).build());
        accounts.setAccountType(accountsDto.getAccountType());
        accounts.setCity(accountsDto.getCity());
        accounts.setCustomerId(accounts.getCustomerId());
        return accounts;
    }

}
