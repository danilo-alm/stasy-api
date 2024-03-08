package com.stasy.api.controllers.sale;

import com.fasterxml.jackson.annotation.JsonView;
import com.stasy.api.domain.Views;
import com.stasy.api.domain.sale.Sale;
import com.stasy.api.dtos.SaleDTO;
import com.stasy.api.infra.ApiConstants;
import com.stasy.api.services.sale.SaleService;
import lombok.AllArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping(ApiConstants.SALE_BASE_URI)
public class SaleController {
    private SaleService service;

    @PostMapping
    public ResponseEntity<Void> createSale(@RequestBody SaleDTO data) {
        Sale newSale = service.createSale(data);
        URI location = URI.create(ApiConstants.PRODUCT_BASE_URI + "/" + newSale.getId());
        return ResponseEntity.created(location).build();
    }

//    @PutMapping
//    public ResponseEntity<Void> updateSale(@PathVariable Long id, @RequestBody SaleDTO data) {
//        Sale newSale = service.createSale(data);
//        URI location = URI.create(ApiConstants.PRODUCT_BASE_URI + "/" + newSale.getId());
//        return ResponseEntity.created(location).build();
//    }

    @GetMapping("/{id}")
    public ResponseEntity<Sale> getSaleById(@PathVariable Long id) {
        Sale sale = service.getSaleById(id);
        return ResponseEntity.ok().body(sale);
    }

    @GetMapping
    @JsonView(Views.QueryingSales.class)
    public ResponseEntity<List<Sale>> getByDate(
            @RequestParam(value="start", required = false)
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
            LocalDateTime start,

            @RequestParam(value="end", required = false)
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
            LocalDateTime end,

            @RequestParam(value="on", required = false)
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
            LocalDateTime on
    ) {
       List<Sale> sales;
        if (on != null) {
            sales = service.getByDate(on);
        } else if (start != null && end != null) {
            sales = service.getByDateBetween(start, end);
        } else if (start != null) {
            sales = service.getByDateAfter(start);
        } else if (end != null) {
            sales = service.getByDateBefore(end);
        } else {
            sales = service.getAllSales();
        }

        return ResponseEntity.ok().body(sales);
    }
}
