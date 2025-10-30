package com.MGoldenPearl.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "microservice-product", url = "localhost:8050")
public interface IProductClient {

    @GetMapping("/products/exists/{productId}")
    boolean validateProductIfExist(@PathVariable Long productId);
}
