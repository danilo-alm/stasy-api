package com.stasy.api.controllers.product;

import com.stasy.api.domain.product.Product;
import com.stasy.api.domain.product.ProductCategory;
import com.stasy.api.dtos.ProductDTO;
import com.stasy.api.infra.ApiConstants;
import com.stasy.api.services.product.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(ApiConstants.PRODUCT_BASE_URI)
public class ProductController {
    private final ProductService service;

    @Autowired
    public ProductController(ProductService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Void> createProduct(@RequestBody ProductDTO data) {
        Product newProduct = service.createProduct(data);
        URI location = URI.create(ApiConstants.PRODUCT_BASE_URI + "/" + newProduct.getId());
        return ResponseEntity.created(location).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateProduct(@PathVariable Long id, @RequestBody ProductDTO data) {
        service.updateProduct(id, data);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}/quantity")
    public ResponseEntity<Void> updateProductQuantity(@PathVariable Long id, @RequestBody Map<String, Long> quantity) {
        if (!quantity.containsKey("quantity")) {
            return ResponseEntity.badRequest().build();
        }
        service.updateProductQuantity(id, quantity.get("quantity"));
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts() {
        return ResponseEntity.ok().body(service.getAllProducts());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Long id) {
        return ResponseEntity.ok().body(service.getProductById(id));
    }

    @GetMapping("/name/{substring}")
    public ResponseEntity<List<Product>> getProductByNameContains(
      @PathVariable String substring,
      @RequestParam(required = false) boolean caseSensitive) {
        if (caseSensitive) {
            return ResponseEntity.ok().body(service.getProductByNameContains(substring));
        }
        return ResponseEntity.ok().body(service.getProductByNameContainsIgnoreCase(substring));
    }

    @GetMapping("/manufacturer/{substring}")
    public ResponseEntity<List<Product>> getProductsByManufacturerContains(
      @PathVariable String substring,
      @RequestParam(required = false) boolean caseSensitive) {
        if (caseSensitive) {
            return ResponseEntity.ok().body(service.getProductsByManufacturerContains(substring));
        }
        return ResponseEntity.ok().body(service.getProductsByManufacturerContainsIgnoreCase(substring));
    }

    @GetMapping("/category/{category}")
    public ResponseEntity<List<Product>> getProductsByCategory(@PathVariable ProductCategory category) {
        return ResponseEntity.ok().body(service.getProductsByCategory(category));
    }

    @GetMapping("/quantity/less-than/{quantity}")
    public ResponseEntity<List<Product>> getProductsByQuantityLessThanEqual(@PathVariable long quantity) {
        return ResponseEntity.ok().body(service.getProductsByQuantityLessThanOrEqualTo(quantity));
    }

    @GetMapping("/quantity/greater-than/{quantity}")
    public ResponseEntity<List<Product>> getProductsByQuantityGreaterThanEqual(@PathVariable long quantity) {
        return ResponseEntity.ok().body(service.getProductsByQuantityGreaterThanOrEqualTo(quantity));
    }
}
