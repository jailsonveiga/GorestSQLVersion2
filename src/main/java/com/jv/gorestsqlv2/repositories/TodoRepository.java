package com.jv.gorestsqlv2.repositories;

import com.jv.gorestsqlv2.models.Todo;
import org.springframework.data.repository.CrudRepository;

public interface TodoRepository extends CrudRepository<Todo, Long> {
}
