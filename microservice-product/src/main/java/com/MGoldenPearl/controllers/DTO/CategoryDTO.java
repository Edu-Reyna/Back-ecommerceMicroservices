package com.MGoldenPearl.controllers.DTO;

import com.MGoldenPearl.entities.CategoryEntity;
import com.MGoldenPearl.entities.ProductEntity;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class CategoryDTO {
    private Long id;
    private String name;
    private List<ProductDTO> products;


    public static CategoryDTO MapperCategoryToDTO(CategoryEntity categoryEntity){
        List<ProductDTO> productDTOS = categoryEntity.getProducts().stream()
                .map(product -> ProductDTO.builder()
                        .id(product.getId())
                        .name(product.getName())
                        .description(product.getDescription())
                        .price(product.getPrice())
                        .stock(product.getStock())
                        .categoryId(product.getCategory().getId())
                        .build())
                .toList();

        return CategoryDTO.builder()
                .id(categoryEntity.getId())
                .name(categoryEntity.getName())
                .products(productDTOS)
                .build();
    }

    public static CategoryEntity MapperDTOToCategory(CategoryDTO categoryDTO){
        return CategoryEntity.builder()
                .id(categoryDTO.getId())
                .name(categoryDTO.getName())
                .build();
    }
}
