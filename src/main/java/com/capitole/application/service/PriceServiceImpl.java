package com.capitole.application.service;

import com.capitole.application.port.in.IPriceService;
import com.capitole.domain.model.Price;
import com.capitole.domain.repository.PriceRepository;
import com.capitole.infrastructure.exception.ResourceNotFoundException;
import com.capitole.infrastructure.rest.dto.response.PriceDto;
import com.capitole.infrastructure.rest.mapper.PriceDtoMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

/**
 * Implementation of the IPriceService.
 *
 * Uses domain repositories and mappers to retrieve and map price information.
 */
@Service
public class PriceServiceImpl implements IPriceService {

    private final PriceRepository priceRepository;
    private final PriceDtoMapper priceDtoMapper;

    /**
     * Constructor for injecting dependencies.
     *
     * @param priceRepository Repository for accessing price data
     * @param priceDtoMapper Mapper for converting domain models to DTOs
     */
    public PriceServiceImpl(PriceRepository priceRepository, PriceDtoMapper priceDtoMapper) {
        this.priceRepository = priceRepository;
        this.priceDtoMapper = priceDtoMapper;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public PriceDto getApplicablePrice(Long productId, Long brandId, LocalDateTime date) {
        Price price = priceRepository.findApplicablePrice(productId, brandId, date).orElseThrow(() -> new ResourceNotFoundException("No applicable price found for the given parameters."));;
        return priceDtoMapper.toDto(price);
    }
}
