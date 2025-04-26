package com.capitole.infrastructure.rest.controller;

import com.capitole.application.service.PriceService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;


@RestController
@RequestMapping("/api/price")
public class PriceRestController {

    private final PriceService priceService;

    public PriceRestController(PriceService priceService) {
        this.priceService = priceService;
    }


    @GetMapping
    public ResponseEntity<?> getPrice(@RequestParam Long productId,
                                      @RequestParam Long brandId,
                                      @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime date) {
        return priceService.getApplicablePrice(productId, brandId, date)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

}
