package com.MGoldenPearl.controllers.DTO;

import com.MGoldenPearl.entities.CategoryEntity;
import com.MGoldenPearl.entities.ProductEntity;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProductDTO {
    private Long id;
    private String name;
    private String description;
    private Double price;
    private Integer stock;
    private Long categoryId;

    public static ProductDTO MapperProductToDTO(ProductEntity productEntity) {

        return ProductDTO.builder()
                .id(productEntity.getId())
                .name(productEntity.getName())
                .description(productEntity.getDescription())
                .price(productEntity.getPrice())
                .stock(productEntity.getStock())
                .categoryId(productEntity.getCategory().getId())
                .build();
    }

    public static ProductEntity MapperDTOToProduct(ProductDTO productDTO) {
        return ProductEntity.builder()
                .id(productDTO.getId())
                .name(productDTO.getName())
                .description(productDTO.getDescription())
                .price(productDTO.getPrice())
                .stock(productDTO.getStock())
                .category(productDTO.getCategoryId() == null ? null : CategoryEntity.builder().id(productDTO.getCategoryId()).build())
                .build();
    }

}