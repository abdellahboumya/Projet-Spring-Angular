package com.library.services;

import java.util.List;

import com.library.entities.Book;

public interface BookService {

	List<Book> getAllAvailableBooks();

	Book getBookById(Long id);

	Book addBook(Book book);

	Book updateBook(Long id, Book book);

	void deleteBook(Long id);

}
