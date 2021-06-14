package com.bigp.productserviceasp.repository;

import com.bigp.productserviceasp.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {
    @Query("SELECT p FROM Product p WHERE p.categoryId = ?1")
    List<Product> findProducts(Long categoryId);

    @Query("SELECT p FROM Product p WHERE p.id = ?1")
    List<Product> findProductById(Long productId);

}