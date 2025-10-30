package com.MGoldenPearl.services.Interfaces;

import com.MGoldenPearl.controllers.DTO.EntryOrderDTO;
import com.MGoldenPearl.controllers.DTO.ProductDTO;

import java.util.List;

public interface IProductService {

    List<ProductDTO> findAll();
    ProductDTO findProduct(Long id);
    void deleteProduct(Long id);
    ProductDTO saveProduct(ProductDTO productDTO);
    List<ProductDTO> findAllProductByCategory(Long id);

    List<ProductDTO> findAllProductsBy(EntryOrderDTO entryOrderDTO);

    boolean ValidateExist(Long productId);
}
