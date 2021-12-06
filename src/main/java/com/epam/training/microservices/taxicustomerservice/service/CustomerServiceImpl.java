package com.epam.training.microservices.taxicustomerservice.service;

import com.epam.training.microservices.taxicustomerservice.exceptions.CustomerNotFoundNotException;
import com.epam.training.microservices.taxicustomerservice.model.Order;
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
    public Order sendOrderCreationRequest(Order order) {
        if (checkIfCustomerExists(order.getUsername())) {
            Order orderDTOWithChainedId = orderClient.sendOrderCreationRequest(order);
            Long id = orderDTOWithChainedId.getId();
            orderDTOWithChainedId.setChainId(id);
            return orderClient.sendOrderUpdateRequest(id, orderDTOWithChainedId);
        } else {
            throw new CustomerNotFoundNotException(order.getUsername());
        }
    }

    @Override
    public Order updateOrder(Long chainId, Order order) {
        if (checkIfCustomerExists(order.getUsername())) {
            order.setId(chainId);
            order.setChainId(chainId);
            return orderClient.sendOrderUpdateRequest(chainId, order);
        } else {
            throw new CustomerNotFoundNotException(order.getUsername());
        }
    }
}
