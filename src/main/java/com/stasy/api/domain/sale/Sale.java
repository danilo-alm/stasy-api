package com.stasy.api.domain.sale;

import com.stasy.api.domain.user.User;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Table(name = "Sales")
@Entity(name = "Sales")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@ToString
public class Sale {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "Date", nullable = false)
    private LocalDateTime date;

    @Column(name = "CustomerName", nullable = false)
    private String customerName;

    @Column(name = "SellerId", nullable = false)
    private String sellerId;

    @Column(name = "Total", nullable = false)
    private BigDecimal total;

    public Sale(String customerName, String sellerId, BigDecimal total) {
        this.date = LocalDateTime.now();
        this.customerName = customerName;
        this.sellerId = sellerId;
        this.total = total;
    }
}