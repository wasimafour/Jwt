package com.app.Jwt.repository;

import com.app.Jwt.model.Posts;
import org.springframework.data.repository.CrudRepository;

public interface PostsRepository extends CrudRepository<Posts,Long> {

}
