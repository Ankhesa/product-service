package com.bigp.productserviceasp.domain;


import lombok.Data;
import java.util.List;

@Data
public class CategoryResponse {
    private final List<Category> categories;
}
