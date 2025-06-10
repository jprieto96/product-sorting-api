package com.example.productsorting.unit;

import com.example.productsorting.product.domain.model.Product;
import com.example.productsorting.product.domain.service.ProductScoringService;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class ProductScoringServiceTest {

    @Test
    void sorts_by_weighted_score() {
        var p1 = new Product("1", "A", 100, Map.of("S", 1, "M", 0, "L", 0));
        var p2 = new Product("2", "B", 50, Map.of("S", 1, "M", 1, "L", 1));

        var service = new ProductScoringService(1, 100);
        var sorted = service.sort(List.of(p1, p2));

        assertThat(sorted.getFirst().getId()).isEqualTo("2");
    }

}
