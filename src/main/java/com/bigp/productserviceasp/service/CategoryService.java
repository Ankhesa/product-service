package com.bigp.productserviceasp.service;

import com.bigp.productserviceasp.rest.controller.domain.Category;
import com.bigp.productserviceasp.rest.controller.domain.CategoryResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    private static final String FURNITURE_CATEGORY = "1";
    private static final String FOOD_CATEGORY = "2";
    private static final String APPLIANCE_CATEGORY = "3";

    public CategoryResponse getCategories(){return new CategoryResponse(getCategoriesList())}

    private List<Category> getCategoriesList() {

    }
}
