package com.MGoldenPearl.services.implementation;

import com.MGoldenPearl.controller.DTO.ProductDTO;
import com.MGoldenPearl.entities.EstatusOrder;
import com.MGoldenPearl.entities.OrderDetailsEntity;
import com.MGoldenPearl.entities.OrderEntity;
import com.MGoldenPearl.repositories.IOrderDetailsRepository;
import com.MGoldenPearl.services.interfaces.IOrderDetailsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class IOrderDetailsServiceImpl implements IOrderDetailsService {

    private final IOrderDetailsRepository orderDetailsRepository;


    @Override
    public OrderDetailsEntity saveOrderDetails(Long orderId, ProductDTO product, Integer quantity) {

        return orderDetailsRepository.save(OrderDetailsEntity.builder()
                .order(OrderEntity.builder().id(orderId).build())
                .productId(product.getId())
                .quantity(quantity)
                .unitPrice(product.getPrice())
                .totalPrice(BigDecimal.valueOf(product.getPrice()).multiply(BigDecimal.valueOf(quantity)))
                .status(EstatusOrder.COMPLETED)
                .build()
        );
    }
}
