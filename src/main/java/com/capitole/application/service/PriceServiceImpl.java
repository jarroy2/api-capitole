package com.capitole.application.service;

import com.capitole.common.PriceDto;
import com.capitole.domain.model.Price;
import com.capitole.domain.repository.PriceRepository;
import com.capitole.infrastructure.rest.mapper.PriceDtoMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class PriceServiceImpl implements IPriceService{

    private final PriceRepository priceRepository;
    private final PriceDtoMapper priceDtoMapper;

    public PriceServiceImpl(PriceRepository priceRepository, PriceDtoMapper priceDtoMapper) {
        this.priceRepository = priceRepository;
        this.priceDtoMapper = priceDtoMapper;
    }

    public Optional<PriceDto> getApplicablePrice(Long productId, Long brandId, LocalDateTime date) {
        Optional<Price> price = priceRepository.findApplicablePrice(productId, brandId, date);
        return price.map(priceDtoMapper::toDto);
    }
}
