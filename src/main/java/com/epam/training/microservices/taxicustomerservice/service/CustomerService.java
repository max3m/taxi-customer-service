package com.epam.training.microservices.taxicustomerservice.service;

import com.epam.training.microservices.taxicustomerservice.model.OrderDTO;

public interface CustomerService {
    boolean checkIfCustomerExists(String username);
    OrderDTO sendOrderCreationRequest(OrderDTO orderDTO);
    OrderDTO updateOrder(Long id, OrderDTO orderDTO);
}
