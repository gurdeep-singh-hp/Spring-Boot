package com.gurdeep.product.controller;

import com.gurdeep.product.dto.CategoryDto;
import com.gurdeep.product.exception.CategoryAlreadyExistException;
import com.gurdeep.product.service.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
@AllArgsConstructor     //For service to autowire else need to add @Autowire above of that service
public class CategoryController {

    private CategoryService categoryService;

    //Create
    @PostMapping
    //public ResponseEntity<CategoryDto> createCategory(@RequestBody CategoryDto categoryDto){
    public ResponseEntity<?> createCategory(@RequestBody CategoryDto categoryDto){
//        try{
//            CategoryDto savedCategory = categoryService.createCategory(categoryDto);
//            return ResponseEntity.status(HttpStatus.CREATED).body(savedCategory);
//        } catch (CategoryAlreadyExistException e) {
//            return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
//        }
       return new ResponseEntity<>(categoryService.createCategory(categoryDto),HttpStatus.CREATED);
    }
    //Get All Category List
    @GetMapping
    public List<CategoryDto> getAllCategory(){  //In case of List not use Response Entity
        return categoryService.getAllCategory();
    }
    //Get Category by id
    @GetMapping("/{id}")
    public CategoryDto getCategoryById(@PathVariable Long id){
        return categoryService.getCategoryById(id);
    }
    //Delete Category ById
    @DeleteMapping("/{id}")
    public String deleteCategory(@PathVariable Long id){
        return  categoryService.deleteCategoryById(id);
    }
    //Update product ById
    @PutMapping("/{id}")
    public CategoryDto updateCategoryById(@RequestBody CategoryDto categoryDto, @PathVariable Long id){
        return categoryService.updateCategoryById(categoryDto, id);
    }

}
