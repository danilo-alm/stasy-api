package com.stasy.api.repositories;

import com.stasy.api.domain.product.Product;
import com.stasy.api.domain.product.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {
    Optional<List<Product>> findByCategory(ProductCategory category);
    Optional<List<Product>> findByNameContains(String name);
    Optional<List<Product>> findByNameContainsIgnoreCase(String name);
    Optional<List<Product>> findByQuantityLessThanEqual(long quantity);
    Optional<List<Product>> findByQuantityGreaterThanEqual(long quantity);
    Optional<List<Product>> findByManufacturerContains(String substring);
    Optional<List<Product>> findByManufacturerContainsIgnoreCase(String substring);
}
