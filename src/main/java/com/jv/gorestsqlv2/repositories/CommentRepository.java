package com.jv.gorestsqlv2.repositories;

import com.jv.gorestsqlv2.models.Comment;
import org.springframework.data.repository.CrudRepository;

public interface CommentRepository extends CrudRepository<Comment, Long> {
}
