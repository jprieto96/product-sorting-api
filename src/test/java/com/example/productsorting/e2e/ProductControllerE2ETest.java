package com.example.productsorting.e2e;

import com.example.productsorting.ProductSortingApplication;
import com.example.productsorting.product.infrastructure.adapter.document.ProductDocument;
import com.example.productsorting.product.infrastructure.adapter.repository.ProductRepositoryMongo;
import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;

import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.hasSize;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = ProductSortingApplication.class)
public class ProductControllerE2ETest {

    @LocalServerPort
    private int port;

    @BeforeEach
    void setup(@Autowired ProductRepositoryMongo repo) {
        RestAssured.port = port;
        repo.deleteAll();
        List.of(
                new ProductDocument("1", "A", 100, Map.of("S", 1, "M", 0)),
                new ProductDocument("2", "B", 10, Map.of("S", 1, "M", 1))
        ).forEach(repo::save);
    }

    @Test
    void returns_sorted_products() {
        given().contentType("application/json")
                .body("{\"weightSales\": 1, \"weightStockRatio\": 50}")
                .when().post("/products/sort")
                .then().statusCode(200)
                .body("$", hasSize(2));
    }

}
