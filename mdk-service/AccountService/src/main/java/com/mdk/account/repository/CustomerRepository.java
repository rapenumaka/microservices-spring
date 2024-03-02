package com.mdk.account.repository;

import com.mdk.account.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

// this interface will transport out entity objects to database
@Repository // Behind the scenes the JPA framework will create a bean implementation of this interface based upon the configurations
public interface CustomerRepository extends JpaRepository<Customer, Long> {


    // This is called derived method
    Optional<Customer> findByMobileNumber(String mobileNumber);

}
