package com.bigp.productserviceasp.service;


import com.bigp.productserviceasp.domain.Product;
import com.bigp.productserviceasp.domain.ProductResponse;
import com.google.common.collect.Lists;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private static final String FURNITURE_CATEGORY = "1";
    private static final String FOOD_CATEGORY = "2";
    private static final String APPLIANCE_CATEGORY = "3";

    public ProductResponse getProducts() {
        return new ProductResponse(getProductList());
    }

    private List<Product> getProductList() {
        Product productSofa = buildProduct("1", "sofa", FURNITURE_CATEGORY);
        Product productBed = buildProduct("2", "bed", FURNITURE_CATEGORY);
        Product productChocolate = buildProduct("3", "chocolate", FOOD_CATEGORY);
        Product productPizza = buildProduct("4", "pizza", FOOD_CATEGORY);
        Product productRefrigerator = buildProduct("5", "refrigerator", APPLIANCE_CATEGORY);
        Product productToaster = buildProduct("6", "toaster", APPLIANCE_CATEGORY);
        return Lists.newArrayList(productSofa, productBed, productChocolate, productPizza,
                productRefrigerator, productToaster);
    }

    private Product buildProduct(String id, String description, String category) {
        return new Product(id, description, category);
    }
}