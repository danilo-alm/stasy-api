package com.stasy.api.services.product;

import com.stasy.api.domain.product.Product;
import com.stasy.api.domain.product.ProductCategory;
import com.stasy.api.dtos.ProductDTO;
import com.stasy.api.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {
    private final ProductRepository repository;

    @Autowired
    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }

    public Product createProduct(ProductDTO data) {
        Product newProduct = new Product(data);
        repository.save(newProduct);
        return newProduct;
    }

    public List<Product> getAllProducts() {
        return repository.findAll();
    }

    public Product getProductById(Long id) {
        return repository.findById(id).orElseThrow(() -> new ProductNotFoundException(id));
    }

    public void updateProductQuantity(Long id, long quantity) {
        Product product = getProductById(id);
        product.setQuantity(quantity);
        repository.save(product);
    }

    public void updateProduct(Long id, ProductDTO data) {
        Product product = getProductById(id);
        product.setName(data.name());
        product.setManufacturer(data.manufacturer());
        product.setPrice(data.price());
        product.setQuantity(data.quantity());
        product.setCategory(data.category());
        repository.save(product);
    }

    public List<Product> getProductByNameContains(String substring) {
        return repository.findByNameContains(substring).orElse(new ArrayList<>());
    }

    public List<Product> getProductByNameContainsIgnoreCase(String substring) {
        return repository.findByNameContainsIgnoreCase(substring).orElse(new ArrayList<>());
    }

    public List<Product> getProductsByManufacturerContains(String substring) {
        return repository.findByManufacturerContains(substring).orElse(new ArrayList<>());
    }

    public List<Product> getProductsByManufacturerContainsIgnoreCase(String substring) {
        return repository.findByManufacturerContainsIgnoreCase(substring).orElse(new ArrayList<>());
    }

    public List<Product> getProductsByCategory(ProductCategory category) {
        return repository.findByCategory(category).orElse(new ArrayList<>());
    }

    public List<Product> getProductsByQuantityLessThanOrEqualTo(long quantity) {
        return repository.findByQuantityLessThanEqual(quantity).orElse(new ArrayList<>());
    }

    public List<Product> getProductsByQuantityGreaterThanOrEqualTo(long quantity) {
        return repository.findByQuantityGreaterThanEqual(quantity).orElse(new ArrayList<>());
    }
}
