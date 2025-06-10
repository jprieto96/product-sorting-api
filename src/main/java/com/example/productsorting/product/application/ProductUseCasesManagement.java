package com.example.productsorting.product.application;

import com.example.productsorting.product.domain.model.Product;
import com.example.productsorting.product.domain.port.ProductPersistencePort;
import com.example.productsorting.product.domain.service.ProductScoringService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductUseCasesManagement implements ProductUseCases {

    private final ProductPersistencePort productPersistencePort;

    @Autowired
    public ProductUseCasesManagement(final ProductPersistencePort productPersistencePort) {
        this.productPersistencePort = productPersistencePort;
    }

    public List<Product> sort(double weightSales, double weightStockRatio) {
        List<Product> products = productPersistencePort.getAll();
        return new ProductScoringService(weightSales, weightStockRatio).sort(products);
    }

}