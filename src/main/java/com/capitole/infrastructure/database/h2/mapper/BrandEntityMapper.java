package com.capitole.infrastructure.database.h2.mapper;

import com.capitole.domain.model.Brand;
import com.capitole.infrastructure.database.h2.entity.BrandEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface BrandEntityMapper {

    @Mapping(source = "id", target = "id")
    @Mapping(source = "name", target = "name")
    Brand toDomain(BrandEntity entity);

    @InheritInverseConfiguration
    BrandEntity toEntity(Brand domain);
}
