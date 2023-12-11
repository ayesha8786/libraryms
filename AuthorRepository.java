package com.application.library.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.application.library.entity.Author;

public interface AuthorRepository extends JpaRepository<Author,Long>{

}
