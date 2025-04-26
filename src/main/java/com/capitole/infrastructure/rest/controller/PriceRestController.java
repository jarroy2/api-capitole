package com.capitole.infrastructure.rest.controller;

import com.capitole.application.service.IPriceService;
import com.capitole.common.PriceDto;
import com.capitole.infrastructure.exception.ErrorResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

/**
 * REST controller for managing price-related endpoints.
 *
 * Exposes HTTP endpoints to retrieve price information based on product, brand, and application date.
 */
@Slf4j
@RestController
@RequestMapping("/api/price")
@Tag(name = "Price API", description = "Operations related to product pricing")
public class PriceRestController {

    private final IPriceService priceService;

    /**
     * Constructor for injecting the PriceService.
     *
     * @param priceService Service handling business logic for prices
     */
    public PriceRestController(IPriceService priceService) {
        this.priceService = priceService;
    }


    /**
     * REST controller endpoint to retrieve the applicable price for a specific product, brand, and date.
     *
     * Accepts product ID, brand ID, and an application date as query parameters.
     * Returns the price details if found; otherwise, responds with HTTP 404.
     *
     * @param productId the identifier of the product
     * @param brandId the identifier of the brand (chain)
     * @param date the application date and time in ISO 8601 format
     * @return ResponseEntity containing the PriceDto if found or 404 Not Found if not
     */
    @GetMapping
    @Operation(
            summary = "Get applicable price",
            description = "Retrieves the applicable price for a product and brand at a specific date and time.",
            responses = {
                    @ApiResponse(responseCode = "200",
                            description = "Applicable price successfully retrieved",
                            content = @Content(mediaType = "application/json", schema = @Schema(implementation = PriceDto.class))),
                    @ApiResponse(
                            responseCode = "404",
                            description = "No applicable price found for the given parameters",
                            content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))
                    )
            }
    )
    public ResponseEntity<PriceDto> getPrice(@Parameter(description = "ID of the product", example = "35455") @RequestParam Long productId,
                                             @Parameter(description = "ID of the brand", example = "1") @RequestParam Long brandId,
                                             @Parameter(description = "Application date and time in ISO format", example = "2020-06-14T10:00:00")
                                          @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime date) {

        log.info("Fetching price for productId={}, brandId={}, date={}", productId, brandId, date);
        return ResponseEntity.ok(priceService.getApplicablePrice(productId, brandId, date));
    }

}
