package com.stasy.api.domain.saleproduct;

import com.stasy.api.domain.product.Product;
import com.stasy.api.domain.sale.Sale;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = {"sale", "product"})
public class SaleProductKey implements Serializable {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "SaleID")
    private Sale sale;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ProductID")
    private Product product;

    @Override
    public String toString() {
        return "SaleProductKey{" +
            "sale=" + sale +
            ", product=" + product +
            '}';
    }
}
