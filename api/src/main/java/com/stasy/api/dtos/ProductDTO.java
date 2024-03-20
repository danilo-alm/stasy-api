package com.stasy.api.dtos;

import com.stasy.api.domain.product.ProductCategory;

import java.math.BigDecimal;

public record ProductDTO(String name, String barcode, String manufacturer, ProductCategory category, BigDecimal price, long quantity) {
}
