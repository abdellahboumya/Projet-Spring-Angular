package com.library.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.library.entities.Book;

public interface BookRepository extends JpaRepository<Book, Long> {

	List<Book> findAllByIsAvailableTrue();
}
