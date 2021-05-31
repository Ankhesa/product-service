package com.bigp.productserviceasp.service;

import com.bigp.productserviceasp.repository.CategoryRepository;
import com.bigp.productserviceasp.domain.CategoryResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    private CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }


    public CategoryResponse getCategories(boolean active) {

        return new CategoryResponse(categoryRepository.findCategories(active));
    }

}
