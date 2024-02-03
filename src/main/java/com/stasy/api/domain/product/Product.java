package com.stasy.api.domain.product;

import com.stasy.api.dtos.ProductDTO;
import jakarta.persistence.*;
import lombok.*;

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
    private String name;
    private String manufacturer;
    @Enumerated(EnumType.STRING)
    private ProductCategory category;
    private double price;
    private long quantity;

    public Product(ProductDTO data) {
         this.name = data.name();
         this.manufacturer = data.manufacturer();
         this.category = data.category();
         this.price = data.price();
         this.quantity = data.quantity();
    }
}
