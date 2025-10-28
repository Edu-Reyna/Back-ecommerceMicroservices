package com.MGoldenPearl.controller;

import com.MGoldenPearl.controller.DTO.EntryOrderDTO;
import com.MGoldenPearl.services.interfaces.IOrderService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order")
@RequiredArgsConstructor
public class OrderController {

    private final IOrderService orderService;

    @PostMapping("/process")
    @ResponseStatus(HttpStatus.OK)
    public void processOrder(@RequestBody @Valid EntryOrderDTO entryOrderDTO){
        orderService.processOrder(entryOrderDTO);
    }

}
