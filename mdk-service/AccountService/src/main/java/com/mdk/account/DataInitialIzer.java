package com.mdk.account;

import com.mdk.account.entity.Account;
import com.mdk.account.entity.AccountRepositoryKey;
import com.mdk.account.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

public class DataInitialIzer implements CommandLineRunner {

    @Autowired
    private AccountRepository accountRepository;

    @Override
    public void run(String... args) throws Exception {

    }
}
