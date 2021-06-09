package com.bigp.productserviceasp.domain;

import lombok.Data;

import java.util.List;

@Data
public class ProductResponse {
    private final List<Product> products;

}
