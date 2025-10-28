package com.MGoldenPearl.repository;

import com.MGoldenPearl.entity.CommentEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ICommentRepository extends MongoRepository<CommentEntity, String> {

    List<CommentEntity> findAllByProductId(Long productId);

}
