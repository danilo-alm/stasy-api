package com.stasy.api.domain.saleproduct;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Embeddable
@Getter
@Setter
@EqualsAndHashCode(of = {"saleId", "productId"})
public class SaleProductKey implements Serializable {

    @Column(name = "SaleID")
    private Long saleId;

    @Column(name = "ProductID")
    private Long productId;
}
