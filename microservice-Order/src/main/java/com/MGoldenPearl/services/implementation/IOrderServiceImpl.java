package com.MGoldenPearl.services.implementation;

import com.MGoldenPearl.client.IProductClient;
import com.MGoldenPearl.client.IUserClient;
import com.MGoldenPearl.controller.DTO.EntryOrderDTO;
import com.MGoldenPearl.controller.DTO.ProductDTO;
import com.MGoldenPearl.entities.EstatusOrder;
import com.MGoldenPearl.entities.OrderDetailsEntity;
import com.MGoldenPearl.entities.OrderEntity;
import com.MGoldenPearl.repositories.IOrderRepository;
import com.MGoldenPearl.services.interfaces.IOrderDetailsService;
import com.MGoldenPearl.services.interfaces.IOrderService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class IOrderServiceImpl implements IOrderService {

    private final IOrderRepository orderRepository;
    private final IProductClient productClient;
    private final IUserClient userClient;
    private final IOrderDetailsService orderDetailsService;

    @Override
    @Transactional
    public void processOrder(EntryOrderDTO entryOrderDTO) {

        boolean userExists = userClient.getConfirmIfExist(entryOrderDTO.customerId());
        if (!userExists){
            throw new IllegalArgumentException("User with ID " + entryOrderDTO.customerId() + " doesn't exist.");
        }

        List<ProductDTO> availableProducts = productClient.findAllProducts(entryOrderDTO);

        OrderEntity order = orderRepository.save(OrderEntity.builder()
                .status(EstatusOrder.PROCESSING)
                .totalAmount(BigDecimal.ZERO)
                .orderDate(LocalDateTime.now())
                .customerId(entryOrderDTO.customerId())
                .build()
        );

        for (ProductDTO productDTO : availableProducts){

            OrderDetailsEntity orderDetailsEntity = orderDetailsService.saveOrderDetails(order.getId(), productDTO,
                                                                            entryOrderDTO.products().get(productDTO.getId()));

            order.setTotalAmount(order.getTotalAmount().add(orderDetailsEntity.getTotalPrice()));
        }
        order.setStatus(EstatusOrder.COMPLETED);
        orderRepository.save(order);
    }

    @Override
    public void cancelOrder(Long orderId) {

    }
}
