package com.capitole.infrastructure.database.h2.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "price")
public class PriceEntity {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    private BrandEntity brand;

    @ManyToOne
    private ProductEntity product;

    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private int priority;
    private BigDecimal price;
    private String curr;

}