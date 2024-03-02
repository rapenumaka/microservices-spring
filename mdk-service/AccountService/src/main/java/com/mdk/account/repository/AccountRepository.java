package com.mdk.account.repository;

import com.mdk.account.entity.Account;
import com.mdk.account.entity.AccountRepositoryKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AccountRepository extends JpaRepository<Account, AccountRepositoryKey> {

    Optional<Account> findByCustomerId(Long customerId);



}
