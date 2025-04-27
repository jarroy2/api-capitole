package com.capitole.infrastructure.database.h2.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Getter
@NoArgsConstructor
@Entity
@Table(name = "brand")
public class BrandEntity {

    @Id
    @GeneratedValue
    private Long id;

    private String name;
}
