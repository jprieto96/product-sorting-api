package com.example.productsorting.product.infrastructure.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ProductRequestDTO {

    private String id;
    private String name;

}
