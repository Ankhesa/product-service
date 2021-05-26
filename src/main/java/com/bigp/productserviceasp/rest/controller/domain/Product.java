package com.bigp.productserviceasp.rest.controller.domain;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class Product {
    private final String id;
    private final String description;
    private final String categoryId;
}
