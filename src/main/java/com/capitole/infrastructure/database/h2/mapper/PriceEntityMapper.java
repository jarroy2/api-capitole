package com.capitole.infrastructure.database.h2.mapper;

import com.capitole.domain.model.Price;
import com.capitole.infrastructure.database.h2.entity.PriceEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 * Mapper for converting PriceEntity objects to domain Price models and vice versa.
 *
 * Helps maintain separation between infrastructure and domain layers.
 */
@Mapper(componentModel = "spring", uses = {BrandEntityMapper.class, ProductEntityMapper.class})
public interface PriceEntityMapper {

    // Mapeo de Entity a Domain
    @Mapping(source = "brand", target = "brand")
    @Mapping(source = "product", target = "product")
    @Mapping(source = "startDate", target = "startDate")
    @Mapping(source = "endDate", target = "endDate")
    @Mapping(source = "priority", target = "priority")
    @Mapping(source = "price", target = "price")
    @Mapping(source = "curr", target = "curr")
    Price toDomain(PriceEntity priceEntity);

    // Mapeo inverso de Domain a Entity usando herencia
    @InheritInverseConfiguration
    PriceEntity toEntity(Price price);


}
