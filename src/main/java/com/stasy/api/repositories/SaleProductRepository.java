package com.stasy.api.repositories;

import com.stasy.api.domain.saleproduct.SaleProduct;
import com.stasy.api.domain.saleproduct.SaleProductKey;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SaleProductRepository extends JpaRepository<SaleProduct, SaleProductKey> {
}
