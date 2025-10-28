package com.MGoldenPearl.controllers;

import com.MGoldenPearl.controllers.DTO.EntryOrderDTO;
import com.MGoldenPearl.controllers.DTO.ProductDTO;
import com.MGoldenPearl.services.Interfaces.IProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {

    private final IProductService productService;

    @GetMapping("/all")
    public ResponseEntity<List<ProductDTO>> getAllProducts() {
        return new ResponseEntity<>(this.productService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductDTO> getProductById(@PathVariable Long id) {
        return new ResponseEntity<>(this.productService.findProduct(id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable Long id) {
        this.productService.deleteProduct(id);
        return new ResponseEntity<>("Product deleted", HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<ProductDTO> saveProduct(@RequestBody ProductDTO productDTO) {
        return new ResponseEntity<>(this.productService.saveProduct(productDTO), HttpStatus.CREATED);
    }

    @GetMapping("/category/{id}")
    public ResponseEntity<List<ProductDTO>> getProductsByCategory(@PathVariable Long id) {
        return new ResponseEntity<>(this.productService.findAllProductByCategory(id), HttpStatus.OK);
    }

    @PostMapping("/allProducts")
    public ResponseEntity<List<ProductDTO>> findAllProductsBy(@RequestBody EntryOrderDTO entryOrderDTO){
        return new ResponseEntity<>(this.productService.findAllProductsBy(entryOrderDTO), HttpStatus.OK);

    }


}
