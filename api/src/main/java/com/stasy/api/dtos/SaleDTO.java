package com.stasy.api.dtos;

import java.util.Map;

public record SaleDTO(String customerName, String sellerId, Map<Long, Integer> products) {
}
