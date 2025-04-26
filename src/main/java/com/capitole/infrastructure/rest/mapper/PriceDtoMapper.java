package com.capitole.infrastructure.rest.mapper;

import com.capitole.common.PriceDto;
import com.capitole.domain.model.Price;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 * Mapper for converting PriceDto objects to domain Price models and vice versa.
 *
 * Helps maintain separation between infrastructure and domain layers.
 */
@Mapper(componentModel = "spring")
public interface PriceDtoMapper {


    // Mapeo de Entity a Domain
    @Mapping(source = "brand.id", target = "brandId")
    @Mapping(source = "product.id", target = "productId")
    @Mapping(source = "startDate", target = "startDate")
    @Mapping(source = "price", target = "finalPrice")
    @Mapping(source = "id", target = "priceList")
    PriceDto toDto(Price priceEntity);

    // Mapeo inverso de Domain a Entity usando herencia
    @InheritInverseConfiguration
    Price toDomain(PriceDto price);
}
