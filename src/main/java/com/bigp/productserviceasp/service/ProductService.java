package com.bigp.productserviceasp.service;


import com.bigp.productserviceasp.domain.Product;
import com.bigp.productserviceasp.domain.ProductResponse;
import com.bigp.productserviceasp.exception.ProductNotFoundException;
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

    public Product getProductById(Long productId) {
        return productRepository.findById(productId)
                .orElseThrow(() ->
                        new ProductNotFoundException("ProductId: " + productId + " not found"));
    }
}
