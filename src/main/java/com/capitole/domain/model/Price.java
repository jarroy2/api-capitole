package com.capitole.domain.model;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
@Builder
@ToString
public class Price {

    private Long id;
    private Brand brand;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private Product product;
    @NotNull
    @Min(value = 0, message = "Price must be positive")
    private BigDecimal price;
    private String curr;
    private Integer priority;


}
