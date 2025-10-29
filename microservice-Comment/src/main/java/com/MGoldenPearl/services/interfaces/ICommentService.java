package com.MGoldenPearl.services.interfaces;

import com.MGoldenPearl.controller.DTO.CommentDTO;
import com.MGoldenPearl.controller.DTO.ResponseCommentDTO;

import java.util.List;

public interface ICommentService {

    List<ResponseCommentDTO> getCommentsByProductId(Long productId);
    void addComment(CommentDTO commentDTO);
    ResponseCommentDTO getCommentById(String commentId);
    void deleteCommentById(String commentId);
    void updateComment(CommentDTO commentDTO);

}
