package com.example.productsorting.product.application;

import com.example.productsorting.product.domain.model.Product;

import java.util.List;

public interface ProductUseCases {

    List<Product> sort(double weightSales, double weightStockRatio);

}