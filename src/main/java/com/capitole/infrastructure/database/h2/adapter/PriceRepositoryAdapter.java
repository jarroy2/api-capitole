package com.capitole.infrastructure.database.h2.adapter;

import com.capitole.domain.model.Price;
import com.capitole.domain.repository.PriceRepository;
import com.capitole.infrastructure.database.h2.mapper.PriceEntityMapper;
import com.capitole.infrastructure.database.h2.repository.PriceJpaRepository;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Optional;

@Component
public class PriceRepositoryAdapter implements PriceRepository {

    private final PriceJpaRepository repository;
    private final PriceEntityMapper priceMapper;

    public PriceRepositoryAdapter(PriceJpaRepository repository, PriceEntityMapper priceMapper) {
        this.repository = repository;
        this.priceMapper = priceMapper;
    }

    @Override
    public Optional<Price> findApplicablePrice(Long productId, Long brandId, LocalDateTime date) {
        return repository.findApplicablePrices(productId, brandId, date)
                .stream()
                .findFirst()
                .map(priceMapper::toDomain);
    }

}
