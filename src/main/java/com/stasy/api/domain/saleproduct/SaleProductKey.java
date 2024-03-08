package com.stasy.api.domain.saleproduct;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

@Embeddable
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = {"saleId", "productId"})
@ToString
public class SaleProductKey implements Serializable {
    @Column(name = "SaleID", nullable = false)
    private Long saleId;

    @Column(name = "ProductID", nullable = false)
    private Long productId;
}
