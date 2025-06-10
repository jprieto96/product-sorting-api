package com.example.productsorting.product.domain.port;

import com.example.productsorting.product.domain.model.Product;

import java.util.List;

public interface ProductPersistencePort {

    List<Product> getAll();

}
