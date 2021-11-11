package com.epam.training.microservices.taxicustomerservice.controller;

import com.epam.training.microservices.taxicustomerservice.model.OrderDTO;
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
    @ResponseStatus(HttpStatus.OK)
    public OrderDTO sendOrderCreationRequest(@RequestBody OrderDTO orderDTO){
        return customerService.sendOrderCreationRequest(orderDTO);
    }

    @PutMapping("/orders/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public OrderDTO sendOrderUpdateRequest(@PathVariable("id") Long id, @RequestBody OrderDTO orderDTO){
        return customerService.updateOrder(id, orderDTO);
    }
}
