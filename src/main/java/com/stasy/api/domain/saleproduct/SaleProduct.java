package com.stasy.api.domain.saleproduct;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Table(name = "SaleProducts")
@Entity(name = "SaleProducts")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode(of = "id")
public class SaleProduct {

    @EmbeddedId
    private SaleProductKey id;

    @Column(name = "Quantity", nullable = false)
    private int quantity;

    @Column(name = "UnitPrice", nullable = false)
    private BigDecimal unitPrice;

    public SaleProduct(Long saleId, Long productId, BigDecimal unitPrice, int quantity) {
        this.id = new SaleProductKey(saleId, productId);
        this.unitPrice = unitPrice;
        this.quantity = quantity;
    }

    public BigDecimal getTotal() {
        return unitPrice.multiply(BigDecimal.valueOf(quantity));
    }
}
