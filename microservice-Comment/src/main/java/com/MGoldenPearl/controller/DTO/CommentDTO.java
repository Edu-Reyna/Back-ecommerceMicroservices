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


    public static CommentEntity toEntity(CommentDTO commentDTO) {
        return CommentEntity.builder()
                .id(commentDTO.getId())
                .comment(commentDTO.getComment())
                .userId(commentDTO.getUserId())
                .productId(commentDTO.getProductId())
                .rating(commentDTO.getRating())
                .build();
    }


}
