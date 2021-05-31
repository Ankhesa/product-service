package com.bigp.productserviceasp.domain;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class Product {
    private final Long id;
    private final String description;
    private final String categoryId;
}
