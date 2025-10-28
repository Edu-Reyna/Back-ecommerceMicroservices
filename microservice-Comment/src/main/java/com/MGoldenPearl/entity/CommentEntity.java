package com.MGoldenPearl.entity;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Builder
@Data
@Document(collection = "comments")
public class CommentEntity {

    @Id
    private String id;

    private String comment;
    private Long userId;

    @Indexed
    private Long productId;
    private Integer rating;

    @CreatedDate
    private LocalDateTime createdDate;

}
