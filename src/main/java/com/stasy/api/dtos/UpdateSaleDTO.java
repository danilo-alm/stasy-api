package com.stasy.api.dtos;

import java.util.Map;

public record UpdateSaleDTO(Long id, String customerName, String sellerId, Map<Long, Integer> products) {
}
