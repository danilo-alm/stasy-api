package com.stasy.api.services.sale;

public class SaleNotFoundException extends RuntimeException {
    public SaleNotFoundException(Long id) {
        super("Sale with id " + id + " not found");
    }
}
