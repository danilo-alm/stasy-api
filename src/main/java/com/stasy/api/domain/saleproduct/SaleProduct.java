package com.stasy.api.domain.saleproduct;

import com.stasy.api.domain.product.Product;
import com.stasy.api.domain.sale.Sale;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

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

    @Column(name = "Quantity", nullable = false)
    private int quantity;

    @Column(name = "Price", nullable = false)
    private BigDecimal price;

    public SaleProduct(SaleProductKey saleProductKey, BigDecimal price, int quantity) {
        this.id = saleProductKey;
        this.price = price;
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "SaleProduct{" +
            "id=" + id +
            ", quantity=" + quantity +
            ", price=" + price +
            '}';
    }
}
