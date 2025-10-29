package com.MGoldenPearl.services.implementations;

import com.MGoldenPearl.client.IUserClient;
import com.MGoldenPearl.controller.DTO.CommentDTO;
import com.MGoldenPearl.controller.DTO.ResponseCommentDTO;
import com.MGoldenPearl.entity.CommentEntity;
import com.MGoldenPearl.repository.ICommentRepository;
import com.MGoldenPearl.services.interfaces.ICommentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements ICommentService {

    private final ICommentRepository commentRepository;
    private final IUserClient userClient;

    @Override
    public List<ResponseCommentDTO> getCommentsByProductId(Long productId) {

        return commentRepository.findAllByProductId(productId)
                .stream().map(e -> ResponseCommentDTO.builder()
                        .id(e.getId())
                        .rating(e.getRating())
                        .comment(e.getComment())
                        .userId(userClient.getUsernameById(e.getUserId()))
                        .createdDate(e.getCreatedDate().toString())
                        .productId(e.getProductId())
                        .build()).toList();
    }

    @Override
    public void addComment(CommentDTO commentDTO) {
        CommentEntity comment = CommentDTO.toEntity(commentDTO);
        commentRepository.insert(comment);
    }

    @Override
    public ResponseCommentDTO getCommentById(String commentId) {

        return commentRepository.findById(commentId).map(e -> ResponseCommentDTO.builder()
                .id(e.getId())
                .rating(e.getRating())
                .comment(e.getComment())
                .userId(userClient.getUsernameById(e.getUserId()))
                .createdDate(e.getCreatedDate().toString())
                .productId(e.getProductId())
                .build()
        ).orElse(null);
    }

    @Override
    public void deleteCommentById(String commentId) {
        commentRepository.findById(commentId).ifPresent(commentRepository::delete);

    }

    @Override
    public void updateComment(CommentDTO commentDTO) {
        CommentEntity comment = commentRepository.findById(commentDTO.getId()).orElseThrow(() -> new IllegalArgumentException("The comment doesn't exists"));

        comment.setRating(commentDTO.getRating());
        comment.setComment(commentDTO.getComment());

        commentRepository.save(comment);
    }
}
