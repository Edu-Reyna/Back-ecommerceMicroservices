package com.MGoldenPearl.client;

import com.MGoldenPearl.controller.DTO.EntryOrderDTO;
import com.MGoldenPearl.controller.DTO.ProductDTO;
import jakarta.validation.Valid;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(name = "microservice-product", url = "localhost:8050")
public interface IProductClient {

    @PostMapping("/products/allProducts")
    List<ProductDTO> findAllProducts(@RequestBody EntryOrderDTO entryOrderDTO);
}
