package com.bigp.productserviceasp.rest.controller;

import com.bigp.productserviceasp.rest.controller.domain.ProductRequest;
import com.bigp.productserviceasp.rest.controller.domain.ProductResponse;
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

    @PostMapping("/product")
    @ResponseBody
    public ResponseEntity<String> getProduct(@RequestBody ProductRequest productRequest) {
        return new ResponseEntity<>("hello from Product Service: " + productRequest.getProductId(), HttpStatus.OK);
    }

    @GetMapping("/products")
    @ResponseBody
    public ResponseEntity<ProductResponse> getProducts() {
        return new ResponseEntity<>(productService.getProducts(), HttpStatus.OK);
    }
}
