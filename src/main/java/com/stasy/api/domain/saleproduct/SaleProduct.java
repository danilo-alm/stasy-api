package com.stasy.api.domain.saleproduct;

import com.stasy.api.domain.product.Product;
import com.stasy.api.domain.sale.Sale;
import jakarta.persistence.*;
import lombok.*;

@Table(name = "SaleProducts")
@Entity(name = "SaleProducts")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class SaleProduct {

    @EmbeddedId
    private SaleProductKey id;

    @ManyToOne
    @MapsId("saleId")
    @JoinColumn(name = "SaleID")
    private Sale sale;

    @ManyToOne
    @MapsId("productId")
    @JoinColumn(name = "ProductID")
    private Product product;

    @Column(name = "Quantity", nullable = false)
    private int quantity;

    @Column(name = "Price", nullable = false)
    private double price;
}
