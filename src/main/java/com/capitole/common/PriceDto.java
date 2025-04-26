package com.capitole.common;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@EqualsAndHashCode
@Getter
@Setter
public class PriceDto {

    private Long productId;
    private Long brandId;
    private Long priceList; // ID de tarifa a aplicar
    private LocalDateTime startDate; // Fecha inicio aplicación
    private LocalDateTime endDate;   // Fecha fin aplicación
    private BigDecimal finalPrice;   // Precio final a aplicar

    public PriceDto(Long productId, Long brandId, Long priceList, LocalDateTime startDate, LocalDateTime endDate, BigDecimal finalPrice) {
        this.productId = productId;
        this.brandId = brandId;
        this.priceList = priceList;
        this.startDate = startDate;
        this.endDate = endDate;
        this.finalPrice = finalPrice;
    }

}
