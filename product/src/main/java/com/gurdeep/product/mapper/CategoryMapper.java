package com.gurdeep.product.mapper;

import com.gurdeep.product.dto.CategoryDto;
import com.gurdeep.product.entity.Category;

public class CategoryMapper {   //Used for E->D and D->E
    //Dto -> E
    public static Category toCategoryEntity(CategoryDto categoryDto){
        Category category = new Category();
        category.setName(categoryDto.getName());
        return category;
    }

    //E->Dto
    public static CategoryDto toCategoryDto(Category category){
        if(category == null){
            return null;
        }
        CategoryDto categoryDto = new CategoryDto();
        categoryDto.setId(category.getId());
        categoryDto.setName(category.getName());
        categoryDto.setProducts(category.getProducts()
                .stream().map(ProductMapper::toProductDto).toList());   //Note
        return categoryDto;
    }
}
