package com.stasy.api.domain.saleproduct;

import com.fasterxml.jackson.annotation.JsonView;
import com.stasy.api.domain.Views;
import com.stasy.api.domain.product.Product;
import com.stasy.api.domain.sale.Sale;
import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
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
    @JsonView(Views.QueryingSalesWithProducts.class)
    private SaleProductKey id;

    @Column(name = "Quantity", nullable = false)
    @JsonView(Views.QueryingSalesWithProducts.class)
    private int quantity;

    @Column(name = "UnitPrice", nullable = false)
    @JsonView(Views.QueryingSalesWithProducts.class)
    private BigDecimal unitPrice;

    public SaleProduct(Sale sale, Product product, BigDecimal unitPrice, int quantity) {
        this.id = new SaleProductKey(sale, product);
        this.unitPrice = unitPrice;
        this.quantity = quantity;
    }

    public BigDecimal getTotal() {
        return unitPrice.multiply(BigDecimal.valueOf(quantity));
    }
}
