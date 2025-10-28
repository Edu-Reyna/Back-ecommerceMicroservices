package com.MGoldenPearl.services.Implementation;

import com.MGoldenPearl.controllers.DTO.CategoryDTO;
import com.MGoldenPearl.entities.CategoryEntity;
import com.MGoldenPearl.repositories.ICategoryRepository;
import com.MGoldenPearl.services.Interfaces.ICategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements ICategoryService {

    private final ICategoryRepository categoryRepository;

    @Override
    public List<CategoryDTO> findAll() {
        List< CategoryEntity> categories = categoryRepository.findAll();
        return categories.stream().map(CategoryDTO::MapperCategoryToDTO).toList();
    }

    @Override
    public CategoryDTO findCategory(Long id) {
        CategoryEntity category = categoryRepository.findById(id).orElse(null);
        if (category != null) {
            return CategoryDTO.MapperCategoryToDTO(category);
        }
        return null;
    }

    @Override
    public void deleteCategory(Long id) {
        categoryRepository.deleteById(id);

    }

    @Override
    public void saveProduct(CategoryDTO categoryDTO) {
        CategoryEntity categoryEntity = CategoryDTO.MapperDTOToCategory(categoryDTO);
        categoryRepository.save(categoryEntity);
    }
}
