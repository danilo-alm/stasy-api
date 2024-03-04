package com.stasy.api.domain.product;

import com.stasy.api.dtos.ProductDTO;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
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

//    @NotBlank(message = "Name is mandatory")
    private String name;

//    @NotBlank(message = "Manufacturer is mandatory")
    private String manufacturer;

    @Enumerated(EnumType.STRING)
//    @NotBlank(message = "Category is mandatory")
    private ProductCategory category;

//    @NotBlank(message = "Price is mandatory")
    private double price;

//    @NotBlank(message = "Quantity is mandatory")
    private long quantity;

    public Product(ProductDTO data) {
         this.name = data.name();
         this.manufacturer = data.manufacturer();
         this.category = data.category();
         this.price = data.price();
         this.quantity = data.quantity();
    }
}
