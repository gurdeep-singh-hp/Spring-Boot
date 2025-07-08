package com.gurdeep.product.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.*;
import java.util.stream.Collectors;

@Data
@Entity
@Table(name="users")
public class User{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String password;

    @ElementCollection(fetch = FetchType.EAGER)
    //@CollectionTable(name = "user_roles_inline") // Optional
    @Enumerated(EnumType.STRING)
    private List<Role> roles = new ArrayList<>();
}
