package com.bigp.productserviceasp.service;

import com.bigp.productserviceasp.rest.controller.domain.Category;
import com.bigp.productserviceasp.rest.controller.domain.CategoryResponse;
import com.google.common.collect.Lists;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    /*private static final String FURNITURE_CATEGORY = "1";
    private static final String FOOD_CATEGORY = "2";
    private static final String APPLIANCE_CATEGORY = "3"; */

    public CategoryResponse getCategories(){return new CategoryResponse(getCategoriesList());}

    private List<Category> getCategoriesList() {
        Category cat1 = buildCategory("1", "1", "Furniture",1);
        Category cat2 = buildCategory("2", "3", "Food",1);
        Category cat3 = buildCategory("3", "2", "Appliances",0);
        return Lists.newArrayList(cat1,cat2,cat3);
    }

    private Category buildCategory(String id, String rank, String name, int active) {
        return new Category(id,rank,name,active);
    }
}
