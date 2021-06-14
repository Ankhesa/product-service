package com.bigp.productserviceasp.service;

import com.bigp.productserviceasp.domain.Product;
import com.bigp.productserviceasp.domain.ProductResponse;
import com.bigp.productserviceasp.repository.ProductRepository;
import org.assertj.core.util.Lists;
import org.hibernate.HibernateException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ProductServiceTest {
    private static final String ERROR_CONNECTING_TO_DATABASE = "error connecting to database";
    private static final long CATEGORY_ID = 1L;
    @Mock
    private Product product;
    @Mock
    private ProductRepository productRepository;
    @InjectMocks
    private ProductService productService;

    @Test
    void shouldReturnAProductResponseWithAListOfProduct() {
        when(productRepository.findProducts(CATEGORY_ID)).thenReturn(Lists.newArrayList(product));

        ProductResponse productResponse = productService.getProductsByCategoryId(CATEGORY_ID);

        verify(productRepository, times(1)).findProducts(CATEGORY_ID);
        assertThat(productResponse.getProducts().size(), is(1));
        assertEquals(productResponse.getProducts().get(0), product);
    }

    @Test
    void shouldThrowExceptionWhenRepositoryThrowsException() {
        when(productRepository.findProducts(any())).thenThrow(new HibernateException(ERROR_CONNECTING_TO_DATABASE));

        Exception exception = assertThrows(HibernateException.class, () -> productService.getProductsByCategoryId(CATEGORY_ID));

        assertThat(exception.getMessage(), is(ERROR_CONNECTING_TO_DATABASE));
    }
}