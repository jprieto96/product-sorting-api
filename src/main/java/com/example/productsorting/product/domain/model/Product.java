package com.example.productsorting.product.domain.model;

import java.util.Map;

public class Product {

    private final String id;
    private final String name;
    private final int salesUnits;
    private final Map<String, Integer> stockPerSize;

    public Product(String id, String name, int salesUnits, Map<String, Integer> stockPerSize) {
        this.id = id;
        this.name = name;
        this.salesUnits = salesUnits;
        this.stockPerSize = Map.copyOf(stockPerSize);
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getSalesUnits() {
        return salesUnits;
    }

    public Map<String, Integer> getStockPerSize() {
        return stockPerSize;
    }

    public double getStockRatio() {
        long available = stockPerSize.values().stream().filter(v -> v > 0).count();
        return stockPerSize.isEmpty() ? 0 : (double) available / stockPerSize.size();
    }

}