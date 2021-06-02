package com.bigp.productserviceasp.service;

import com.bigp.productserviceasp.domain.Category;
import com.bigp.productserviceasp.domain.CategoryResponse;
import com.bigp.productserviceasp.repository.CategoryRepository;
import org.assertj.core.util.Lists;
import org.hibernate.HibernateException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyBoolean;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CategoryServiceTest {

    private static final String MY_PRODUCT = "myProduct";
    @Mock
    private Category category;
    @Mock
    private CategoryRepository categoryRepository;
    @InjectMocks
    private CategoryService categoryService;

    @Test
    void shouldGetActiveCategories() {
        List<Category> categories = Lists.newArrayList(category);
        when(categoryRepository.findCategories(true)).thenReturn(categories);
        when(category.getId()).thenReturn(5L);

        CategoryResponse categoryResponse = categoryService.getCategories(true);

        verify(categoryRepository, times(1)).findCategories(true);
        assertNotNull(categoryResponse);
        assertThat(categoryResponse.getCategories().size(), is(1));
        assertThat(categoryResponse.getCategories().get(0).getId(), is(5L));

    }

    @Test
    void shouldGetInactiveCategories() {
        List<Category> categories = Lists.newArrayList(category);
        when(categoryRepository.findCategories(false)).thenReturn(categories);
        when(category.getDescription()).thenReturn(MY_PRODUCT);

        CategoryResponse categoryResponse = categoryService.getCategories(false);

        verify(categoryRepository, times(1)).findCategories(false);
        assertNotNull(categoryResponse);
        assertThat(categoryResponse.getCategories().size(), is(1));
        assertThat(categoryResponse.getCategories().get(0).getDescription(), is(MY_PRODUCT));

    }

    @Test
    void shouldThrowExceptionWhenRepositoryThrowsException() {
        when(categoryRepository.findCategories(anyBoolean())).thenThrow(new HibernateException("error connecting to db"));

        assertThrows(HibernateException.class, () -> categoryService.getCategories(true));

        verify(categoryRepository, times(1)).findCategories(true);
    }

}