package com.boot.blog.infrastructure.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.boot.blog.domain.model.entity.Hello;

public interface HelloDao extends JpaRepository<Hello, Integer>{

}
