package com.boot.blog.infrastructure.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.boot.blog.domain.model.entity.Post;

public interface PostDao extends JpaRepository<Post,Integer>{

}
