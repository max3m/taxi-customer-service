package com.epam.training.microservices.taxicustomerservice.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Order {
    private Long id;
    private Long chainId;
    private String username;
    private String driverUsername;
    private String status;
    private String information;
}
