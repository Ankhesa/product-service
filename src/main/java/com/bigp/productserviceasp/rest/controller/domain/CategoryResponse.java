package com.bigp.productserviceasp.rest.controller.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
public class CategoryResponse {
    private final List<Category> categories;
}
