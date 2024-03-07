package com.stasy.api.domain.product;

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
    private Long id;

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
         this.manufacturer = data.manufacturer();
         this.category = data.category();
         this.price = data.price();
         this.quantity = data.quantity();
    }
}
