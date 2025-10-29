package com.MGoldenPearl.controller;

import com.MGoldenPearl.controller.DTO.CommentDTO;
import com.MGoldenPearl.controller.DTO.ResponseCommentDTO;
import com.MGoldenPearl.services.interfaces.ICommentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comments")
@RequiredArgsConstructor
public class CommentController {

    private final ICommentService commentService;

    @GetMapping("/product/{productId}")
    public ResponseEntity<List<ResponseCommentDTO>> getCommentsByProductId(@PathVariable Long productId){
        return new ResponseEntity<>(commentService.getCommentsByProductId(productId), HttpStatus.OK);
    }

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public void addComment(@Valid @RequestBody CommentDTO commentDTO){
        commentService.addComment(commentDTO);
    }

    @GetMapping("/comment/{commentId}")
    public ResponseEntity<ResponseCommentDTO> getCommentById(@PathVariable String commentId){
        return new ResponseEntity<>(commentService.getCommentById(commentId), HttpStatus.OK);
    }

    @DeleteMapping("/comment/{commentId}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteCommentById(@PathVariable String commentId){
        commentService.deleteCommentById(commentId);
    }

    @PatchMapping("comment")
    @ResponseStatus(HttpStatus.OK)
    public void updateComment(@Valid @RequestBody CommentDTO commentDTO){
        commentService.updateComment(commentDTO);
    }

}
