package com.gurdeep.product.repository;

import com.gurdeep.product.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepository extends JpaRepository<Product, Long> {

}
