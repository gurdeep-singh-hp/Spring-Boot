package com.gurdeep.product.controller;

import com.gurdeep.product.dto.ProductDto;
import com.gurdeep.product.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
@AllArgsConstructor
public class ProductController {

    private ProductService productService;

    //Create Product
    @PostMapping
    public ResponseEntity<ProductDto> createProduct(@RequestBody ProductDto productDto){
        return new ResponseEntity<>(productService.createProduct(productDto), HttpStatus.CREATED);
    }

    //Get All Product
    @GetMapping
    public List<ProductDto> getAllProduct(){
        return productService.getAllProduct();
    }

    //Get Product ById
    @GetMapping
    public ProductDto getProductById(@PathVariable Long id){
        return productService.getProductById(id);
    }

    //Delete Product ById
    @DeleteMapping
    public String deleteProduct(@PathVariable Long id){
        return productService.deleteProduct(id);
    }

    //Update product ById
    @PutMapping("/{id}")
    public ProductDto updateProductById(@RequestBody ProductDto productDto, @PathVariable Long id){
        return productService.updateProductById(productDto, id);
    }

}
