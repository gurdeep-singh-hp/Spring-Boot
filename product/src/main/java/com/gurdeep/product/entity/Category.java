package com.gurdeep.product.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
//@Table(name="category")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL)   //category  from Product entity field. Used for mapping
                                                   // cascade = CascadeType.ALL  for remove all Product of a Category if deleted
    private List<Product> products = new ArrayList<>();
}
