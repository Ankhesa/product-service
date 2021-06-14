package com.bigp.productserviceasp.controller;

import com.bigp.productserviceasp.domain.ProductResponse;
import com.bigp.productserviceasp.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/products/{categoryId}")
    public ResponseEntity<ProductResponse> getProductsByCategoryId(@PathVariable(value="categoryId") Long categoryId) {
        return new ResponseEntity<>(productService.getProductsByCategoryId(categoryId), HttpStatus.OK);
    }

    @GetMapping("/product/{productId}")
    public ResponseEntity<ProductResponse> getProduct(@PathVariable(value="productId") Long productId) {
        return new ResponseEntity<>(productService.getProduct(productId),HttpStatus.OK);
    }
}
