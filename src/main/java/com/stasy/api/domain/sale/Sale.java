package com.stasy.api.domain.sale;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonView;
import com.stasy.api.domain.user.User;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Table(name = "Sales")
@Entity(name = "Sales")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Sale {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "Date", nullable = false)
    private LocalDateTime date;

    @Column(name = "CustomerName", nullable = false)
    private String customerName;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "SellerID", nullable = false)
    private User sellerId;

    @Column(name = "Total", nullable = false)
    private BigDecimal total;

    public Sale(String customerName, User sellerId, BigDecimal total) {
        this.date = LocalDateTime.now();
        this.customerName = customerName;
        this.sellerId = sellerId;
        this.total = total;
    }

    @Override
    public String toString() {
        return "Sale{" +
            "id=" + id +
            ", date=" + date +
            ", customerName='" + customerName + '\'' +
            ", sellerId=" + sellerId +
            ", total=" + total +
            '}';
    }
}