package com.MGoldenPearl.controller.DTO;


import com.MGoldenPearl.entities.EstatusOrder;
import com.MGoldenPearl.entities.OrderDetailsEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderDTO {

    private Long id;

    private Long customerId;

    private LocalDateTime orderDate;

    private BigDecimal totalAmount;

    private String status;

    private List<OrderDetailsDTO> orderDetails;
}
