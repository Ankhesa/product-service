package com.bigp.productserviceasp.domain;

import lombok.*;
import javax.persistence.*;

@Data
@Entity
@Table(name = "categories")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String rank;
    private String name;
    private boolean active;
    private String description;

}
