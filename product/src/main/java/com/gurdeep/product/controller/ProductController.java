package com.gurdeep.product.controller;

import com.gurdeep.product.dto.ProductDto;
import com.gurdeep.product.service.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(
        name= "Product Rest API CRUD Operation",
        description = "Create, Read, Update, Delete Operation for Product Rest API"
)
@RestController
@RequestMapping("/api/products")
@AllArgsConstructor
public class ProductController {

    private ProductService productService;

    //Create Product
    @ApiResponse(
            responseCode = "201",
            description = "Created"
    )
    @PreAuthorize("hasAuthority('ROLE_Admin') or hasAuthority('ROLE_Seller')")
    @PostMapping
    public ResponseEntity<ProductDto> createProduct(@RequestBody ProductDto productDto){
        return new ResponseEntity<>(productService.createProduct(productDto), HttpStatus.CREATED);
    }

    //Get All Product
    @Operation(
            summary = "Fetch all products",
            description = "Rest API to Fetch all products."
    )
    @GetMapping
    public List<ProductDto> getAllProduct(){
        return productService.getAllProduct();
    }

    //Get Product ById
    @GetMapping("/{id}")
    public ProductDto getProductById(@PathVariable Long id){
        return productService.getProductById(id);
    }

    //Delete Product ById
    @DeleteMapping("/{id}")
    public String deleteProduct(@PathVariable Long id){
        return productService.deleteProduct(id);
    }

    //Update product ById
    @PutMapping("/{id}")
    public ProductDto updateProductById(@RequestBody ProductDto productDto, @PathVariable Long id){
        return productService.updateProductById(productDto, id);
    }

}
