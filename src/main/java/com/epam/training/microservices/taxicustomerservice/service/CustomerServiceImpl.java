package com.epam.training.microservices.taxicustomerservice.service;

import com.epam.training.microservices.taxicustomerservice.exceptions.CustomerNotFoundNotException;
import com.epam.training.microservices.taxicustomerservice.model.OrderDTO;
import com.epam.training.microservices.taxicustomerservice.repository.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;
    private final OrderClient orderClient;

    @Override
    public boolean checkIfCustomerExists(String username) {
        return customerRepository.existsCustomerByUsername(username);
    }

    @Override
    public OrderDTO sendOrderCreationRequest(OrderDTO orderDTO) {
        if (checkIfCustomerExists(orderDTO.getUsername())) {
            return orderClient.sendOrderCreationRequest(orderDTO);
        } else {
            throw new CustomerNotFoundNotException(orderDTO.getUsername());
        }
    }

    @Override
    public OrderDTO updateOrder(Long id, OrderDTO orderDTO) {
        if (checkIfCustomerExists(orderDTO.getUsername())) {
            return orderClient.sendOrderUpdateRequest(id, orderDTO);
        } else {
            throw new CustomerNotFoundNotException(orderDTO.getUsername());
        }
    }
}
