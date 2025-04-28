package com.capitole.infrastructure.rest.service;

import com.capitole.application.port.in.IPriceService;
import com.capitole.infrastructure.rest.dto.response.PriceDto;
import com.capitole.infrastructure.rest.mapper.PriceDtoMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class PriceQueryService {

    private final IPriceService priceService;
    private final PriceDtoMapper priceDtoMapper;

    public PriceQueryService(IPriceService priceService, PriceDtoMapper priceDtoMapper) {
        this.priceService = priceService;
        this.priceDtoMapper = priceDtoMapper;
    }

    public PriceDto getApplicablePrice(Long productId, Long brandId, LocalDateTime date) {
        return priceDtoMapper.toDto(
                priceService.getApplicablePrice(productId, brandId, date)
        );
    }
}
