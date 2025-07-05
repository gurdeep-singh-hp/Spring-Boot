package com.gurdeep.product.service;

import com.gurdeep.product.dto.CategoryDto;
import com.gurdeep.product.entity.Category;
import com.gurdeep.product.mapper.CategoryMapper;
import com.gurdeep.product.repository.CategoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CategoryService {
    private CategoryRepository categoryRepository;

    //Create Category
    public CategoryDto createCategory(CategoryDto categoryDto){
        Category category = CategoryMapper.toCategoryEntity(categoryDto);
        category = categoryRepository.save(category);
        return CategoryMapper.toCategoryDto(category);
    }
    //Get All Category
    public List<CategoryDto> getAllCategory(){
       return categoryRepository.findAll().stream().map(CategoryMapper::toCategoryDto).toList();
    }
    //Get Category ById
    public CategoryDto getCategoryById(Long id){
        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Category not found"));
        return CategoryMapper.toCategoryDto(category);
    }
    //Delete Category ById
    public String deleteCategoryById(Long id){
        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Category not found for id: "+ id));
        categoryRepository.deleteById(id);
        return "Category delete successfully";
    }
    //Update product ById
    public CategoryDto updateCategoryById(CategoryDto categoryDto, Long id){
        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Category not found for id: "+ id));
        category.setName(categoryDto.getName());
        categoryRepository.save(category);
        return CategoryMapper.toCategoryDto(category);
    }
}
