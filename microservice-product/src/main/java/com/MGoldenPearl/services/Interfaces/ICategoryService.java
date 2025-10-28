package com.MGoldenPearl.services.Interfaces;

import com.MGoldenPearl.controllers.DTO.CategoryDTO;
import com.MGoldenPearl.controllers.DTO.ProductDTO;

import java.util.List;

public interface ICategoryService {

    List<CategoryDTO> findAll();
    CategoryDTO findCategory(Long id);
    void deleteCategory(Long id);
    void saveProduct(CategoryDTO categoryDTO);
}
