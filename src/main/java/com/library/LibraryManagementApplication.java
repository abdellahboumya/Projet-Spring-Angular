package com.library;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.reactive.CorsConfigurationSource;
import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource;

import com.library.entities.Book;
import com.library.repositories.BookRepository;

@SpringBootApplication
public class LibraryManagementApplication implements CommandLineRunner {

	@Autowired
	private BookRepository bookRepository;

	public static void main(String[] args) {
		SpringApplication.run(LibraryManagementApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
//		List<Book> books = new ArrayList<>();
//		books.add(new Book(null, "To Kill a Mockingbird", "Harper Lee",
//				"The Pulitzer Prize-winning novel about a child's view of race and justice in the Depression-era South",
//				true, "https://images.gr-assets.com/books/1436732693l/2657.jpg", new String[] { "Fiction", "Classics" },
//				null));
//		books.add(new Book(null, "Pride and Prejudice", "Jane Austen",
//				"A classic novel about manners, upbringing, morality, education, and marriage in Georgian England",
//				true, "https://images.gr-assets.com/books/1392791656l/1342.jpg", new String[] { "Fiction", "Classics" },
//				null));
//		books.add(new Book(null, "The Great Gatsby", "F. Scott Fitzgerald",
//				"A novel about decadence, idealism, resistance to change, social upheaval, and excess, exploring the decadence and excess of the Jazz Age",
//				true, "https://images.gr-assets.com/books/1523689126l/4671.jpg", new String[] { "Fiction", "Classics" },
//				null));
//		bookRepository.saveAll(books);

	}

}
