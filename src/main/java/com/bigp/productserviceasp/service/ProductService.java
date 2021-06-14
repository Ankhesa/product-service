package com.bigp.productserviceasp.service;


import com.bigp.productserviceasp.domain.CategoryResponse;
import com.bigp.productserviceasp.domain.Product;
import com.bigp.productserviceasp.domain.ProductResponse;
import com.bigp.productserviceasp.repository.ProductRepository;
import com.google.common.collect.Lists;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    public ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public ProductResponse getProductsByCategoryId(Long categoryId) {
        return new ProductResponse(productRepository.findProducts(categoryId));
    }

    public ProductResponse getProduct(Long productId) {
        return new ProductResponse(productRepository.findProductById(productId));
    }
}
