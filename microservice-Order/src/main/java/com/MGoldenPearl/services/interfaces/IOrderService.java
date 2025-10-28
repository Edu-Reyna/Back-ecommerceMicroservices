package com.MGoldenPearl.services.interfaces;

import com.MGoldenPearl.controller.DTO.EntryOrderDTO;
import com.MGoldenPearl.controller.DTO.ProductDTO;

import java.util.List;

public interface IOrderService {

    void processOrder(EntryOrderDTO entryOrderDTO);

    void cancelOrder(Long orderId);


}
