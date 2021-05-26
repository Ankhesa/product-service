package com.bigp.productserviceasp.rest.controller.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Category {
    private final String id;
    private final String rank;
    private final String name;
    private final int active;

}
