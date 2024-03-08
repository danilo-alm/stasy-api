package com.stasy.api.repositories;

import com.stasy.api.domain.sale.Sale;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface SaleRepository extends JpaRepository<Sale, Long>{
    Optional<List<Sale>> findByDate(LocalDateTime date);
    Optional<List<Sale>> findByDateAfter(LocalDateTime date);
    Optional<List<Sale>> findByDateBefore(LocalDateTime date);
    Optional<List<Sale>> findByDateBetween(LocalDateTime start, LocalDateTime end);
}
