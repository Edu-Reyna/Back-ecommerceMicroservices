package com.MGoldenPearl.services.interfaces;

import com.MGoldenPearl.controller.DTO.OrderDetailsDTO;
import com.MGoldenPearl.controller.DTO.ProductDTO;
import com.MGoldenPearl.entities.OrderDetailsEntity;

public interface IOrderDetailsService {

    OrderDetailsEntity saveOrderDetails(Long orderId, ProductDTO product, Integer integer);
}
