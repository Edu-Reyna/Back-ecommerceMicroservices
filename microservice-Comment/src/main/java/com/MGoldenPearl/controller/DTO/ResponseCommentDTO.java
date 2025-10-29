package com.MGoldenPearl.controller.DTO;

import com.MGoldenPearl.entity.CommentEntity;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ResponseCommentDTO {

    private String id;

    @NotBlank(message = "The comment can't be empty")
    private String comment;

    @NotNull(message = "The user ID can't be empty")
    @Positive(message = "The user ID has to be positive")
    private String userId;

    @NotNull(message = "The product ID can't be empty")
    @Positive(message = "The product ID has to be positive")
    private Long productId;

    @NotNull(message = "The rating can't be empty")
    @Positive(message = "The rating has to be positive")
    private Integer rating;
    private String createdDate;

}
