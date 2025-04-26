package com.capitole.domain.model;

import lombok.*;

@Getter
@AllArgsConstructor
@Builder
@ToString
public class Product {

    private Long id;
    private String name;

}
