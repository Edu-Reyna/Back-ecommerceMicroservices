package com.MGoldenPearl;

import com.MGoldenPearl.entity.CommentEntity;
import com.MGoldenPearl.repository.ICommentRepository;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest

class MicroserviceCommentApplicationTests {

	@Autowired
	private ICommentRepository commentRepository;

	@Test
	void testInsertComment() {
		CommentEntity comment = CommentEntity.builder()
				.comment("Great product!")
				.userId(123L)
				.productId(456L)
				.rating(5)
				.build();

		comment = commentRepository.save(comment);

		System.out.println("Inserted Comment: " + comment.getComment());
	}

}
