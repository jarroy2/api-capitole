package com.capitole.common;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * Data Transfer Object (DTO) for exposing price information through the API.
 *
 * Contains the necessary fields to respond to client requests.
 */
@EqualsAndHashCode
@Getter
@Setter
@AllArgsConstructor
@Schema(description = "DTO representing detailed price information.")
public class PriceDto {

    @Schema(description = "Product identifier", example = "35455")
    private Long productId;

    @Schema(description = "Brand identifier", example = "1")
    private Long brandId;

    @Schema(description = "Price list identifier applied to the product", example = "2")
    private Long priceList;

    @Schema(description = "Start date and time when the price becomes effective", example = "2020-06-14T00:00:00")
    private LocalDateTime startDate;

    @Schema(description = "End date and time until the price is valid", example = "2020-12-31T23:59:59")
    private LocalDateTime endDate;

    @Schema(description = "Final price to apply to the product", example = "35.50")
    private BigDecimal finalPrice;


}
