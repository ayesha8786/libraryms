package com.application.library.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.application.library.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}
