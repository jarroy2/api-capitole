package com.capitole.application.port.in;


import com.capitole.domain.model.Price;
import com.capitole.infrastructure.exception.ResourceNotFoundException;
import java.util.Optional;

import java.time.LocalDateTime;

/**
 * Service port for handling operations related to pricing.
 *
 * Provides functionality to retrieve the applicable price
 * based on product ID, brand ID, and a specific application date.
 */
public interface IPriceService {

    /**
     * Finds the applicable price for a given product and brand at a specific date and time.
     *
     * @param productId the identifier of the product
     * @param brandId the identifier of the brand (chain)
     * @param date the date and time for which the price must be applicable
     * @return the PriceDto representing the applicable price
     * @throws ResourceNotFoundException if no applicable price is found
     */
    Price getApplicablePrice(Long productId, Long brandId, LocalDateTime date);

}
