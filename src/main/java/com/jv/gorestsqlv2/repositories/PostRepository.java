package com.jv.gorestsqlv2.repositories;

import com.jv.gorestsqlv2.models.Post;
import org.springframework.data.repository.CrudRepository;

public interface PostRepository extends CrudRepository<Post, Long> {
}
