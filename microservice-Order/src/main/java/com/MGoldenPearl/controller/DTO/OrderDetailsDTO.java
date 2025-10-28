package com.MGoldenPearl.controller.DTO;

import com.MGoldenPearl.entities.EstatusOrder;
import com.MGoldenPearl.entities.OrderDetailsEntity;
import com.MGoldenPearl.entities.OrderEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderDetailsDTO {

    private Long id;

    private Long productId;

    private Integer quantity;

    private double unitPrice;

    private BigDecimal totalPrice;

    private String status;

    private Long orderId;

    public static OrderDetailsDTO mapperOrderDetailToDTO (OrderDetailsEntity orderDetails) {
        return OrderDetailsDTO.builder()
                .id(orderDetails.getId())
                .productId(orderDetails.getProductId())
                .quantity(orderDetails.getQuantity())
                .unitPrice(orderDetails.getUnitPrice())
                .totalPrice(orderDetails.getTotalPrice())
                .status(orderDetails.getStatus().name())
                .orderId(orderDetails.getId())
                .build();
    }

    public static OrderDetailsEntity mapperDTOToOrderDetail (OrderDetailsDTO orderDetailsDTO) {
        return OrderDetailsEntity.builder()
                .id(orderDetailsDTO.getId())
                .productId(orderDetailsDTO.getProductId())
                .quantity(orderDetailsDTO.getQuantity())
                .unitPrice(orderDetailsDTO.getUnitPrice())
                .totalPrice(orderDetailsDTO.getTotalPrice())
                .status(EstatusOrder.valueOf(orderDetailsDTO.getStatus()))
                .build();
    }
}
