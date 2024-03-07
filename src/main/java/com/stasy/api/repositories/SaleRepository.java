package com.stasy.api.repositories;

import com.stasy.api.domain.sale.Sale;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SaleRepository extends JpaRepository<Sale, Long>{
}
