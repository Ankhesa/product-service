package com.bigp.productserviceasp.domain;

import lombok.*;
import javax.persistence.*;
import java.util.*;

@Data
@Entity
@Table(name = "categories")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String ranking;
    private String name;
    private boolean active;
    private String description;

    @OneToMany()
    @JoinColumn(name = "categoryId")
    private List<Product> products;

}
