package com.epam.training.microservices.taxicustomerservice.service;

import com.epam.training.microservices.taxicustomerservice.model.Order;

public interface CustomerService {
    boolean checkIfCustomerExists(String username);
    Order sendOrderCreationRequest(Order orderDTO);
    Order updateOrder(Long id, Order order);
}
