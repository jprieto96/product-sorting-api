package com.example.productsorting.product.infrastructure.adapter.repository;

import com.example.productsorting.product.domain.model.Product;
import com.example.productsorting.product.infrastructure.adapter.document.ProductDocument;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public interface ProductRepositoryMongo extends MongoRepository<ProductDocument, String> {

    default List<Product> findAllAsDomain() {
        return findAll().stream().map(productDocument ->
                new Product(productDocument.getId(), productDocument.getName(), productDocument.getSalesUnits(), productDocument.getStockPerSize())
        ).collect(Collectors.toList());
    }

}