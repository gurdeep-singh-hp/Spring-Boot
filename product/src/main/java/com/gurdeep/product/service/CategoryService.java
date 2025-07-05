package com.gurdeep.product.service;

import com.gurdeep.product.dto.CategoryDto;
import com.gurdeep.product.entity.Category;
import com.gurdeep.product.mapper.CategoryMapper;
import com.gurdeep.product.repository.CategoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

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
}
