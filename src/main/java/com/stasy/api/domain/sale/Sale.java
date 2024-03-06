package com.stasy.api.domain.sale;

import com.stasy.api.domain.user.User;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

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
    private String id;

    @Column(name = "Date", nullable = false)
    private LocalDate date;

    @Column(name = "CustomerName", nullable = false)
    private String customerName;

    @ManyToOne
    @JoinColumn(name = "SellerID", nullable = false)
    private User sellerId;
}