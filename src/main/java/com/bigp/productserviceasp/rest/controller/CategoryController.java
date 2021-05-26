package com.bigp.productserviceasp.rest.controller;

import com.bigp.productserviceasp.rest.controller.domain.CategoryResponse;
import com.bigp.productserviceasp.rest.controller.domain.ProductResponse;
import com.bigp.productserviceasp.service.CategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

public class CategoryController {
    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/categories")
    @ResponseBody
    public ResponseEntity<CategoryResponse> getCategories() {
        return new ResponseEntity<>(categoryService.getCategories(), HttpStatus.OK);
    }
}
