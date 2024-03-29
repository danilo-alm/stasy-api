package com.stasy.api.domain.product;

import com.fasterxml.jackson.annotation.JsonView;
import com.stasy.api.domain.Views;
import com.stasy.api.dtos.ProductDTO;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Table(name="Products")
@Entity(name="Products")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of="id")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonView(Views.QueryingSalesWithProducts.class)
    private Long id;

    @Column(name = "Barcode", nullable = false)
    private String barcode;

    @Column(name = "Name", nullable = false)
    private String name;

    @Column(name = "Manufacturer", nullable = false)
    private String manufacturer;

    @Enumerated(EnumType.STRING)
    @Column(name = "Category", nullable = false)
    private ProductCategory category;

    @Column(name = "Price", nullable = false)
    private BigDecimal price;

    @Column(name = "Quantity", nullable = false)
    private long quantity;

    public Product(ProductDTO data) {
         this.name = data.name();
         this.barcode = data.barcode();
         this.manufacturer = data.manufacturer();
         this.category = data.category();
         this.price = data.price();
         this.quantity = data.quantity();
    }

    public void setQuantity(long quantity) {
        this.quantity = quantity < 0 ? 0 : quantity;
    }
}
