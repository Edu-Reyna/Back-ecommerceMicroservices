package com.MGoldenPearl.controller.DTO;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.util.Map;

public record EntryOrderDTO(

        @NotNull(message = "The customer ID can't be empty")
        @Positive(message = "The customer ID has to be positive")
        Long customerId,

        @NotEmpty(message = "The products can't be empty")
        Map<
        @NotNull(message = "The ID doesn't have to be in blank") Long,
        @Positive(message = "The quantity has to be positive") Integer
        > products
) {
}
