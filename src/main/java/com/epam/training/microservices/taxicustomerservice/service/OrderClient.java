package com.epam.training.microservices.taxicustomerservice.service;

import com.epam.training.microservices.taxicustomerservice.model.OrderDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient("order-service")
public interface OrderClient {

    @PostMapping("/api/orders")
    OrderDTO sendOrderCreationRequest(@RequestBody OrderDTO order);

    @PutMapping("/api/orders/{id}")
    OrderDTO sendOrderUpdateRequest(@PathVariable("id") Long id, @RequestBody OrderDTO order);
}
