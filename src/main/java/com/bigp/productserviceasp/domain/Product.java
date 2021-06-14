package com.bigp.productserviceasp.domain;

import lombok.*;
import javax.persistence.*;

@Data
@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;
    private String name;
    private  String description;
    private  Long categoryId;
}
