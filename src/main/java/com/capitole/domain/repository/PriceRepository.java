package com.capitole.domain.repository;

import com.capitole.domain.model.Price;

import java.time.LocalDateTime;
import java.util.Optional;

/**
 * Domain repository interface for accessing price data.
 *
 * Acts as an abstraction to decouple the domain layer from persistence mechanisms.
 */
public interface PriceRepository {

    /**
     * Finds the applicable price for a given product, brand, and date.
     *
     * @param productId ID of the product
     * @param brandId ID of the brand
     * @param date Date and time to apply
     * @return an Optional containing the applicable Price if found, otherwise an empty Optional
     */
    Optional<Price> findApplicablePrice(Long productId, Long brandId, LocalDateTime date);

}
