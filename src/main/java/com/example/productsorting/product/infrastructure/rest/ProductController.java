package com.example.productsorting.product.infrastructure.rest;

import com.example.productsorting.product.application.ProductUseCases;
import com.example.productsorting.product.domain.model.Product;
import com.example.productsorting.product.infrastructure.rest.dto.ProductRequestDTO;
import com.example.productsorting.product.infrastructure.rest.dto.SortRequestDTO;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductUseCases productUseCases;

    public ProductController(ProductUseCases productUseCases) {
        this.productUseCases = productUseCases;
    }

    @PostMapping("/sort")
    public List<ProductRequestDTO> sort(@RequestBody SortRequestDTO sortRequestDTO) {
        List<Product> sorted = productUseCases.sort(sortRequestDTO.getWeightSales(), sortRequestDTO.getWeightStockRatio());
        return sorted.stream()
                .map(p -> new ProductRequestDTO(p.getId(), p.getName()))
                .collect(Collectors.toList());
    }

}
