package com.capitole.application.service;

import com.capitole.application.port.in.IPriceService;
import com.capitole.domain.model.Price;
import com.capitole.domain.repository.PriceRepository;
import com.capitole.infrastructure.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import java.util.Optional;

import java.time.LocalDateTime;

/**
 * Implementation of the IPriceService.
 *
 * Uses domain repositories and mappers to retrieve and map price information.
 */
@Service
public class PriceServiceImpl implements IPriceService {

    private final PriceRepository priceRepository;

    /**
     * Constructor for injecting dependencies.
     *
     * @param priceRepository Repository for accessing price data
     */
    public PriceServiceImpl(PriceRepository priceRepository) {
        this.priceRepository = priceRepository;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Price getApplicablePrice(Long productId, Long brandId, LocalDateTime date) {
        return priceRepository.findApplicablePrice(productId, brandId, date)
                .orElseThrow(() -> new ResourceNotFoundException("No applicable price found for the given parameters."));
    }
}
