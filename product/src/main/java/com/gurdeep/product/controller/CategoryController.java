package com.gurdeep.product.controller;

import com.gurdeep.product.dto.CategoryDto;
import com.gurdeep.product.service.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/categories")
@AllArgsConstructor     //For service to autowire else need to add @Autowire above of that service
public class CategoryController {

    private CategoryService categoryService;

    //Create
    @PostMapping
    public ResponseEntity<CategoryDto> createCategory(@RequestBody CategoryDto categoryDto){
       return new ResponseEntity<>(categoryService.createCategory(categoryDto),HttpStatus.CREATED);
    }

    //update by id

    //Delete by id

    //list All

    //Get One
}
