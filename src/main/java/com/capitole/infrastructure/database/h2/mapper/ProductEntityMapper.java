package com.capitole.infrastructure.database.h2.mapper;

import com.capitole.domain.model.Product;
import com.capitole.infrastructure.database.h2.entity.ProductEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ProductEntityMapper {

    @Mapping(source = "id", target = "id")
    @Mapping(source = "name", target = "name")
    Product toDomain(ProductEntity entity);

    @InheritInverseConfiguration
    ProductEntity toEntity(Product domain);
}
