package com.epam.training.microservices.taxicustomerservice.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class OrderDTO {
    private Long id;
    private String username;
    private String driverUsername;
    private String status;
    private String information;
}
