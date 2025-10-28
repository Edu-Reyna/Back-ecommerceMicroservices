package com.MGoldenPearl.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "microservice-user", url = "localhost:8090")
public interface IUserClient {

    @GetMapping("users/user/{userId}")
    boolean getConfirmIfExist(@PathVariable Long userId);
}
