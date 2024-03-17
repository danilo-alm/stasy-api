package com.stasy.api.services.product;

public class ProductNotFoundException extends RuntimeException {

    public ProductNotFoundException(Long id) {
        super("Product with id " + id + " not found");
    }

    public ProductNotFoundException(String barcode) {
        super("Product with barcode " + barcode + " not found");
    }
}
