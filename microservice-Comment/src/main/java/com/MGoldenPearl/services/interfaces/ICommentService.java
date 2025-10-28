package com.MGoldenPearl.services.interfaces;

import com.MGoldenPearl.controller.DTO.CommentDTO;

import java.util.List;

public interface ICommentService {

    List<CommentDTO> getCommentsByProductId(Long productId);
    void addComment(CommentDTO commentDTO);
}
