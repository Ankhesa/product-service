package com.bigp.productserviceasp.controller;

import com.bigp.productserviceasp.domain.ProductRequest;
import com.bigp.productserviceasp.domain.ProductResponse;
import com.bigp.productserviceasp.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("/products")
    @ResponseBody
    public ResponseEntity<ProductResponse> getProductsByCategoryId(@RequestBody ProductRequest productRequest) {
        return new ResponseEntity<>(productService.getProductsByCategoryId(productRequest.getCategoryId()), HttpStatus.OK);
    }
}
