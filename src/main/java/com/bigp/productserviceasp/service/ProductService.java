package com.bigp.productserviceasp.service;


import com.bigp.productserviceasp.domain.Product;
import com.bigp.productserviceasp.domain.ProductResponse;
import com.bigp.productserviceasp.exception.CategoryIdNotFoundException;
import com.bigp.productserviceasp.exception.ProductNotFoundException;
import com.bigp.productserviceasp.repository.ProductRepository;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public ProductResponse getProductsByCategoryId(Long categoryId) {
        List<Product> products = productRepository.findProducts(categoryId);
        if(CollectionUtils.isEmpty(products)) {
            throw new CategoryIdNotFoundException("No products found for category id: " + categoryId);
        }
        return new ProductResponse(products);
    }

    public Product getProductById(Long productId) {
        return productRepository.findById(productId)
                .orElseThrow(() ->
                        new ProductNotFoundException("ProductId: " + productId + " not found"));
    }
}
