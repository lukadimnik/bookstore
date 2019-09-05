package com.example.Bookstore;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.Bookstore.domain.Book;
import com.example.Bookstore.domain.BookRepository;

@SpringBootApplication
public class BookstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(BookRepository repository) {
		return (args) -> {
			Book b1 = new Book("1984", "George Orwell", "1948", "23-lsld", "23");
			Book b2 = new Book("Na planini", "Joze Seliskar", "1900", "76-sdf", "20");
			Book b3 = new Book("Rudnik", "Lovro Kuhar", "1990", "21-hrh", "19");

			repository.save(b1);
			repository.save(b2);
			repository.save(b3);
		};
	}
}
