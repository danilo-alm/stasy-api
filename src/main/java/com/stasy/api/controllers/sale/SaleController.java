package com.stasy.api.controllers.sale;

import com.stasy.api.domain.sale.Sale;
import com.stasy.api.dtos.SaleDTO;
import com.stasy.api.infra.ApiConstants;
import com.stasy.api.services.sale.SaleService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping(ApiConstants.SALE_BASE_URI)
public class SaleController {
    private SaleService service;

    @GetMapping
    public ResponseEntity<List<Sale>> getAllSales() {
        return ResponseEntity.ok(service.getAllSales());
    }

    @PostMapping
    public ResponseEntity<Void> createSale(@RequestBody SaleDTO data) {
        Sale newSale = service.createSale(data);
        URI location = URI.create(ApiConstants.PRODUCT_BASE_URI + "/" + newSale.getId());
        return ResponseEntity.created(location).build();
    }
}
