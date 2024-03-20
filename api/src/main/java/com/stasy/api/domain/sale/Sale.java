package com.stasy.api.domain.sale;

import com.fasterxml.jackson.annotation.JsonView;
import com.stasy.api.domain.Views;
import com.stasy.api.domain.saleproduct.SaleProduct;
import com.stasy.api.domain.user.User;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

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
    @JsonView(Views.QueryingSales.class)
    private Long id;

    @Column(name = "Date", nullable = false)
    @JsonView(Views.QueryingSales.class)
    private LocalDateTime date;

    @Column(name = "CustomerName", nullable = false)
    @JsonView(Views.QueryingSales.class)
    private String customerName;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "SellerId", nullable = false)
    @JsonView(Views.QueryingSales.class)
    private User seller;

    @Column(name = "Total", nullable = false)
    @JsonView(Views.QueryingSales.class)
    private BigDecimal total;

    @OneToMany(mappedBy = "id.sale", cascade = CascadeType.ALL)
    @JsonView(Views.QueryingSalesWithProducts.class)
    private List<SaleProduct> saleProducts;

    public Sale(String customerName, User seller) {
        this.date = LocalDateTime.now();
        this.customerName = customerName;
        this.seller = seller;
        this.total = BigDecimal.ZERO;
    }
}