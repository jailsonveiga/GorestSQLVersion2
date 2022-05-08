package com.jv.gorestsqlv2.repositories;

import com.jv.gorestsqlv2.models.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
}
