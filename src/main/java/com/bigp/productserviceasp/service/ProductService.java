package com.bigp.productserviceasp.service;


import com.bigp.productserviceasp.domain.ProductResponse;
import com.bigp.productserviceasp.repository.ProductRepository;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public ProductResponse getProductsByCategoryId(Long categoryId) {
        return new ProductResponse(productRepository.findProducts(categoryId));
    }
}
