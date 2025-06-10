package com.example.productsorting.product.infrastructure.adapter.document;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Map;

@Data
@Document("products")
@AllArgsConstructor
public class ProductDocument {

    @Id
    private String id;
    private String name;
    private int salesUnits;
    private Map<String, Integer> stockPerSize;

    public ProductDocument() {}

}