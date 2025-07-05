package com.gurdeep.product.service;

import com.gurdeep.product.dto.ProductDto;
import com.gurdeep.product.entity.Category;
import com.gurdeep.product.entity.Product;
import com.gurdeep.product.mapper.ProductMapper;
import com.gurdeep.product.repository.CategoryRepository;
import com.gurdeep.product.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProductService {

    private ProductRepository productRepository;
    private CategoryRepository categoryRepository;

    //Create Product
    public ProductDto createProduct(ProductDto productDto){
        //Check if categoryId Exist or Not
        Category category = categoryRepository.findById(productDto.getCategoryId())
                .orElseThrow(()-> new RuntimeException("Category not found!"));

        Product product = ProductMapper.toProductEntity(productDto, category);
        product = productRepository.save(product);
        return ProductMapper.toProductDto(product);
    }

    //Get All Product
    public List<ProductDto> getAllProduct(){
        return productRepository.findAll().stream().map(ProductMapper::toProductDto).toList();
    }
    //Get Product ById
    public ProductDto getProductById(Long id){
        Product product = productRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Product not found for id: "+ id));
        return ProductMapper.toProductDto(product);
    }
    //Delete Product ById
    public String deleteProduct(Long id){
        Product product = productRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Product not found for id: "+ id));
        productRepository.deleteById(id);
        return "Product delete successfully";
    }
    //Update product ById
    public ProductDto updateProductById(ProductDto productDto, Long id){
        Product product = productRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Product not found for id: "+ id));

        //Need to check if Category changed and if they exist or not
        Long cid = productDto.getCategoryId();
        Category category = categoryRepository.findById(cid)
                .orElseThrow(()-> new RuntimeException("Product not found for id: "+ id +" " +
                        "and Category for id "+ cid));

        product.setName(productDto.getName());
        product.setDescription(productDto.getDescription());
        product.setPrice(productDto.getPrice());
        product.setCategory(category);

        productRepository.save(product);
        return ProductMapper.toProductDto(product);

    }
}
