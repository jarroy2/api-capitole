package com.capitole.infrastructure.database.h2.adapter;

import com.capitole.domain.model.Price;
import com.capitole.domain.repository.PriceRepository;
import com.capitole.infrastructure.database.h2.mapper.PriceEntityMapper;
import com.capitole.infrastructure.database.h2.repository.PriceJpaRepository;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Optional;

/**
 * Adapter implementation of PriceRepository using an H2 database.
 *
 * Interacts with the database layer to retrieve price entities and map them into domain models.
 */
@Component
public class PriceRepositoryAdapter implements PriceRepository {

    private final PriceJpaRepository repository;
    private final PriceEntityMapper priceEntityMapper;

    /**
     * Constructor for injecting dependencies.
     *
     * @param repository JPA repository for price entities
     * @param priceEntityMapper Mapper for converting entities to domain models
     */
    public PriceRepositoryAdapter(PriceJpaRepository repository, PriceEntityMapper priceEntityMapper) {
        this.repository = repository;
        this.priceEntityMapper = priceEntityMapper;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Optional<Price> findApplicablePrice(Long productId, Long brandId, LocalDateTime date) {
        return repository.findApplicablePrices(productId, brandId, date)
                .stream()
                .findFirst()
                .map(priceEntityMapper::toDomain);
    }



}
