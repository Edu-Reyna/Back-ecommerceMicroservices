package com.MGoldenPearl.services.Implementation;

import com.MGoldenPearl.controllers.DTO.EntryOrderDTO;
import com.MGoldenPearl.controllers.DTO.ProductDTO;
import com.MGoldenPearl.entities.ProductEntity;
import com.MGoldenPearl.repositories.IProductRepository;
import com.MGoldenPearl.services.Interfaces.IProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements IProductService {

    private final IProductRepository productRepository;

    @Override
    public List<ProductDTO> findAll() {

        return productRepository.findAll().stream().map(ProductDTO::MapperProductToDTO).toList();
    }

    @Override
    public ProductDTO findProduct(Long id) {
        ProductEntity product = productRepository.findById(id).orElse(null);
        if(product != null){
            return ProductDTO.MapperProductToDTO(product);
        }
        return null;
    }

    @Override
    public void deleteProduct(Long id) {

        productRepository.deleteById(id);

    }

    @Override
    public ProductDTO saveProduct(ProductDTO productDTO) {
        ProductEntity productEntity = ProductDTO.MapperDTOToProduct(productDTO);
        productEntity = productRepository.save(productEntity);
        return ProductDTO.MapperProductToDTO(productEntity);
    }

    @Override
    public List<ProductDTO> findAllProductByCategory(Long id) {

        return productRepository.findAllByCategory_Id(id).stream().map(ProductDTO::MapperProductToDTO).toList();
    }

    @Override
    public List<ProductDTO> findAllProductsBy(EntryOrderDTO entryOrderDTO) {
        List<ProductDTO> productDTOS = new ArrayList<>();

        for (Long productId : entryOrderDTO.products().keySet()){

            ProductEntity productEntity = productRepository.findById(productId).orElse(null);

            if (productEntity == null) {
                log.info("Product with ID {} not found.", productId);
                continue;
            }

            if (productEntity.getStock() < entryOrderDTO.products().get(productId)){
                log.info("Insufficient stock for product ID {}. Available: {}, Requested: {}",
                        productId, productEntity.getStock(), entryOrderDTO.products().get(productId));
            }

            if (productEntity.getStock() >= entryOrderDTO.products().get(productId)){
                productDTOS.add(ProductDTO.MapperProductToDTO(productEntity));
                productEntity.setStock(productEntity.getStock() - entryOrderDTO.products().get(productId));
                productRepository.save(productEntity);
            }
        }

        return productDTOS;
    }
}
