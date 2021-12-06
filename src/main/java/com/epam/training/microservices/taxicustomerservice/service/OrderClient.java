package com.epam.training.microservices.taxicustomerservice.service;

import com.epam.training.microservices.taxicustomerservice.model.Order;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient("order-service")
public interface OrderClient {

    @PostMapping("/api/orders")
    Order sendOrderCreationRequest(@RequestBody Order order);

    @PutMapping("/api/orders/{chainId}")
    Order sendOrderUpdateRequest(@PathVariable("chainId") Long id, @RequestBody Order order);
}
