package com.capitole.application.service;

import com.capitole.common.PriceDto;
import java.util.Optional;

import java.time.LocalDateTime;

public interface IPriceService {

    Optional<PriceDto> getApplicablePrice(Long productId, Long brandId, LocalDateTime date);

}
