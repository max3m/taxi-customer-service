package com.epam.training.microservices.taxicustomerservice.service;

import com.epam.training.microservices.taxicustomerservice.model.Customer;
import com.epam.training.microservices.taxicustomerservice.repository.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DataInit  implements ApplicationRunner {
    private final CustomerRepository customerRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        long count = customerRepository.count();

        if(count == 0) {
            for (int i = 0; i < 10; i++) {
                Customer customer = new Customer("Customer" + i, "Customer" + i + "@mail.ru");
                customerRepository.save(customer);
            }
        }
    }
}
