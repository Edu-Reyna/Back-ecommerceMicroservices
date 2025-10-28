package com.MGoldenPearl.controller.DTO;

import com.MGoldenPearl.entity.CommentEntity;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CommentDTO {

    private String id;
    private String comment;
    private Long userId;
    private Long productId;
    private Integer rating;
    private String createdDate;


    public static CommentDTO fromEntity(CommentEntity commentEntity) {
        return CommentDTO.builder()
                .id(commentEntity.getId())
                .comment(commentEntity.getComment())
                .userId(commentEntity.getUserId())
                .productId(commentEntity.getProductId())
                .rating(commentEntity.getRating())
                .build();
    }


}
