package com.blog.application.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.blog.application.entities.Comment;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Integer> {

}
