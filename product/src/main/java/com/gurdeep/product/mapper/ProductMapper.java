package com.gurdeep.product.mapper;

import com.gurdeep.product.dto.ProductDto;
import com.gurdeep.product.entity.Category;
import com.gurdeep.product.entity.Product;

public class ProductMapper {
    //Dto->E
    public static Product toProductEntity(ProductDto productDto, Category category){
        Product product = new Product();
        product.setName(productDto.getName());
        product.setDescription(productDto.getDescription());
        product.setPrice(productDto.getPrice());
        product.setCategory(category);              // Note it

        return product;
    }
    //E->Dto
    public static ProductDto toProductDto(Product product){
        ProductDto productDto = new ProductDto();
        productDto.setId(product.getId());
        productDto.setName(product.getName());
        productDto.setDescription(product.getDescription());
        productDto.setPrice(product.getPrice());
        productDto.setCategoryId(product.getCategory().getId());

        return productDto;
    }
}
