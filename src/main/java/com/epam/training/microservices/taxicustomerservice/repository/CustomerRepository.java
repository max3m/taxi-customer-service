package com.epam.training.microservices.taxicustomerservice.repository;

import com.epam.training.microservices.taxicustomerservice.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
    boolean existsCustomerByUsername(String username);
}
