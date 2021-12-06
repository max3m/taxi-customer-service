package com.epam.training.microservices.taxicustomerservice.controller;

import com.epam.training.microservices.taxicustomerservice.model.Order;
import com.epam.training.microservices.taxicustomerservice.service.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/api")
public class CustomerController {
    private final CustomerService customerService;

    @PostMapping("/orders")
    @ResponseStatus(HttpStatus.CREATED)
    public Order sendOrderCreationRequest(@RequestBody Order order){
        return customerService.sendOrderCreationRequest(order);
    }

    @PutMapping("/orders/{chainId}")
    @ResponseStatus(HttpStatus.CREATED)
    public Order sendOrderUpdateRequest(@PathVariable("chainId") Long chainId, @RequestBody Order order){
        return customerService.updateOrder(chainId, order);
    }
}
