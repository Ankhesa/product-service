package com.bigp.productserviceasp.controller;

import com.bigp.productserviceasp.domain.CategoryResponse;
import com.bigp.productserviceasp.service.CategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CategoryController {
    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/categories")
    public ResponseEntity<CategoryResponse> getCategories(@RequestParam("active") boolean active) {
        return new ResponseEntity<>(categoryService.getCategories(active), HttpStatus.OK);
    }
}
