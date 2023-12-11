package com.application.library.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.application.library.entity.Publisher;

public interface PublisherRepository extends JpaRepository<Publisher, Long> {

}
