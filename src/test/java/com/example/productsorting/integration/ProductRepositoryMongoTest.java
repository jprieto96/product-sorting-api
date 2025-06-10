package com.example.productsorting.integration;

import com.example.productsorting.product.infrastructure.adapter.document.ProductDocument;
import com.example.productsorting.product.infrastructure.adapter.repository.ProductRepositoryMongo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

@DataMongoTest
public class ProductRepositoryMongoTest {

    @Autowired
    ProductRepositoryMongo repository;

    @Test
    void saves_and_retrieves_product() {
        var doc = new ProductDocument();
        doc.setId("10");
        doc.setName("Test Shirt");
        doc.setSalesUnits(10);
        doc.setStockPerSize(Map.of("S", 5, "M", 0));

        repository.save(doc);

        var result = repository.findById("10");
        assertThat(result).isPresent();
        assertThat(result.get().getName()).isEqualTo("Test Shirt");
    }

}
