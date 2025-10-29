package com.MGoldenPearl.controllers;

import com.MGoldenPearl.services.interfaces.IUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final IUserService userService;

    @GetMapping("/user/{userId}")
    public boolean getConfirmIfExist(@PathVariable Long userId){
        return userService.existsById(userId);
    }

    @GetMapping("/name/{userId}")
    public String getUsernameById(@PathVariable Long userId){
        return userService.getUsernameById(userId);
    }
}
