package com.capitole.infrastructure.database.h2.adapter;

import com.capitole.domain.model.Brand;
import com.capitole.domain.model.Price;
import com.capitole.domain.model.Product;
import com.capitole.domain.repository.PriceRepository;
import com.capitole.infrastructure.database.h2.entity.PriceEntity;
import com.capitole.infrastructure.database.h2.repository.PriceJpaRepository;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Optional;

@Component
public class PriceRepositoryAdapter implements PriceRepository {

    private final PriceJpaRepository repository;

    public PriceRepositoryAdapter(PriceJpaRepository repository) {
        this.repository = repository;
    }

    @Override
    public Optional<Price> findApplicablePrice(Long productId, Long brandId, LocalDateTime date) {
        return repository.findApplicablePrices(productId, brandId, date)
                .stream()
                .findFirst()
                .map(this::mapToDomain);
    }

    private Price mapToDomain(PriceEntity entity) {
        return Price.builder()
                .id(entity.getId())
                .brand(new Brand(entity.getBrand().getId(), entity.getBrand().getName()))
                .product(new Product(entity.getProduct().getId(), entity.getProduct().getName()))
                .startDate(entity.getStartDate())
                .endDate(entity.getEndDate())
                .priority(entity.getPriority())
                .price(entity.getPrice())
                .curr(entity.getCurr())
                .build();
    }
}
