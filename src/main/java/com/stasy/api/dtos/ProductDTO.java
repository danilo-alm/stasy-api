package com.stasy.api.dtos;

import com.stasy.api.domain.product.ProductCategory;

public record ProductDTO(String name, String manufacturer, ProductCategory category, double price, long quantity) {
}
