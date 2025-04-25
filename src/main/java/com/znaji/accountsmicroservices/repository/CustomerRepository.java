package com.znaji.accountsmicroservices.repository;

import com.znaji.accountsmicroservices.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
