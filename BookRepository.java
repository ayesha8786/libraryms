package com.application.library.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.application.library.entity.Book;

public interface BookRepository extends JpaRepository<Book, Long> {

}
