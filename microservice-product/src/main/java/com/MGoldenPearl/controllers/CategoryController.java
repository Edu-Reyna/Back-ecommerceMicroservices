package com.MGoldenPearl.controllers;

import com.MGoldenPearl.controllers.DTO.CategoryDTO;
import com.MGoldenPearl.services.Interfaces.ICategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categories")
@RequiredArgsConstructor
public class CategoryController {

    private final ICategoryService categoryService;

    @GetMapping("/all")
    public ResponseEntity<List<CategoryDTO>> getAllCategories() {
        return new ResponseEntity<>(this.categoryService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoryDTO> getCategoryById(@PathVariable Long id) {
        return new ResponseEntity<>(this.categoryService.findCategory(id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCategory(@PathVariable Long id) {
        this.categoryService.deleteCategory(id);
        return new ResponseEntity<>("Category deleted", HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<String> saveCategory(@RequestBody CategoryDTO categoryDTO) {
        this.categoryService.saveProduct(categoryDTO);
        return new ResponseEntity<>("Category saved", HttpStatus.CREATED);
    }

}
