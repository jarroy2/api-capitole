package com.capitole.application.service;

import com.capitole.domain.model.Price;
import com.capitole.domain.repository.PriceRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class PriceService {

    private final PriceRepository priceRepository;

    public PriceService(PriceRepository priceRepository) {
        this.priceRepository = priceRepository;
    }

    public Optional<Price> getApplicablePrice(Long productId, Long brandId, LocalDateTime date) {
        return priceRepository.findApplicablePrice(productId, brandId, date);
    }
}
