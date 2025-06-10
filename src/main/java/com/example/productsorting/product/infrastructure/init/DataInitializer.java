package com.example.productsorting.product.infrastructure.init;


import com.example.productsorting.product.infrastructure.adapter.document.ProductDocument;
import com.example.productsorting.product.infrastructure.adapter.repository.ProductRepositoryMongo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public class DataInitializer implements CommandLineRunner {

    private final ProductRepositoryMongo repository;

    public DataInitializer(ProductRepositoryMongo repository) {
        this.repository = repository;
    }

    @Override
    public void run(String... args) {
        if (repository.count() == 0) {
            List<ProductDocument> products = List.of(
                    new ProductDocument("1", "V-NECK BASIC SHIRT", 100, Map.of("S", 4, "M", 9, "L", 0)),
                    new ProductDocument("2", "CONTRASTING FABRIC T-SHIRT", 50, Map.of("S", 35, "M", 9, "L", 9)),
                    new ProductDocument("3", "RAISED PRINT T-SHIRT", 80, Map.of("S", 20, "M", 2, "L", 20)),
                    new ProductDocument("4", "PLEATED T-SHIRT", 3, Map.of("S", 25, "M", 30, "L", 10)),
                    new ProductDocument("5", "CONTRASTING LACE T-SHIRT", 650, Map.of("S", 0, "M", 1, "L", 0)),
                    new ProductDocument("6", "SLOGAN T-SHIRT", 20, Map.of("S", 9, "M", 2, "L", 5))
            );
            repository.saveAll(products);
            System.out.println("Productos de ejemplo cargados en MongoDB.");
        }
    }
}
