package com.bigp.productserviceasp.domain;

import lombok.*;
import javax.persistence.*;

@Data
@Entity
@Table(name = "categories")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private final Long id;
    private final String rank;
    private final String name;
    private final int active;
    private String description;

}
