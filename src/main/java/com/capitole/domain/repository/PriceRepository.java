package com.capitole.domain.repository;

import com.capitole.domain.model.Price;

import java.time.LocalDateTime;
import java.util.Optional;

public interface PriceRepository {

    Optional<Price> findApplicablePrice(Long productId, Long brandId, LocalDateTime date);

}
