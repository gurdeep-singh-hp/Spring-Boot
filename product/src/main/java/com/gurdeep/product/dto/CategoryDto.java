package com.gurdeep.product.dto;

import lombok.*;

import java.util.List;

@Data   //Getter Setter RequiredArgsConstructor ToString EqualsAndHashCode Value
@AllArgsConstructor
@NoArgsConstructor
public class CategoryDto {
    private Long id;
    private String name;
    private List<ProductDto> products;
}
