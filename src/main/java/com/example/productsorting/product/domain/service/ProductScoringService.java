package com.example.productsorting.product.domain.service;

import com.example.productsorting.product.domain.model.Product;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ProductScoringService {

    private final double weightSales;
    private final double weightStockRatio;

    public ProductScoringService(double weightSales, double weightStockRatio) {
        this.weightSales = weightSales;
        this.weightStockRatio = weightStockRatio;
    }

    public double score(Product p) {
        return (p.getSalesUnits() * weightSales) + (p.getStockRatio() * weightStockRatio);
    }

    public List<Product> sort(List<Product> products) {
        return products.stream()
                .sorted(Comparator.comparingDouble(this::score).reversed())
                .collect(Collectors.toList());
    }

}