package com.example.productsorting.product.infrastructure.adapter;

import com.example.productsorting.product.domain.model.Product;
import com.example.productsorting.product.domain.port.ProductPersistencePort;
import com.example.productsorting.product.infrastructure.adapter.repository.ProductRepositoryMongo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ProductSpringJpaAdapter implements ProductPersistencePort {

    private final ProductRepositoryMongo productRepositoryMongo;

    public ProductSpringJpaAdapter(ProductRepositoryMongo productRepositoryMongo) {
        this.productRepositoryMongo = productRepositoryMongo;
    }

    @Override
    public List<Product> getAll() {
        return productRepositoryMongo.findAllAsDomain();
    }

}
