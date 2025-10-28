package com.MGoldenPearl.controllers.DTO;

import java.util.Map;

public record EntryOrderDTO(
        Long customerId,
        Map<Long, Integer> products
) {
}
