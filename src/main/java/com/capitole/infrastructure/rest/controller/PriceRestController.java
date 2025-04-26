package com.capitole.infrastructure.rest.controller;

import com.capitole.application.service.IPriceService;
import com.capitole.application.service.PriceServiceImpl;
import com.capitole.common.PriceDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;


@RestController
@RequestMapping("/api/price")
@Tag(name = "Price API", description = "Operations related to product pricing")
public class PriceRestController {

    private final IPriceService priceService;

    public PriceRestController(IPriceService priceService) {
        this.priceService = priceService;
    }


    @GetMapping
    @Operation(
            summary = "Get applicable price",
            description = "Retrieves the applicable price for a product and brand at a specific date and time.",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Price found"),
                    @ApiResponse(responseCode = "404", description = "No applicable price found")
            }
    )
    public ResponseEntity<PriceDto> getPrice(@Parameter(description = "ID of the product", example = "35455") @RequestParam Long productId,
                                             @Parameter(description = "ID of the brand", example = "1") @RequestParam Long brandId,
                                             @Parameter(description = "Application date and time in ISO format", example = "2020-06-14T10:00:00")
                                          @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime date) {
        return priceService.getApplicablePrice(productId, brandId, date)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

}
