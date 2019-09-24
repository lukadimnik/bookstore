package com.example.Bookstore;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.Bookstore.domain.Book;
import com.example.Bookstore.domain.BookRepository;
import com.example.Bookstore.domain.Category;
import com.example.Bookstore.domain.CategoryRepository;

@SpringBootApplication
public class BookstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(BookRepository repository, CategoryRepository categoryRepository) {
		return (args) -> {

			categoryRepository.save(new Category("Fiction"));
			categoryRepository.save(new Category("History"));
			categoryRepository.save(new Category("Fantasy"));

			Book b1 = new Book("1984", "George Orwell", "1948", "23-lsld", "15",
					categoryRepository.findByName("Fantasy"));
			Book b2 = new Book("Na planini", "Joze Seliskar", "1900", "76-sdf", "20",
					categoryRepository.findByName("History"));
			Book b3 = new Book("Rudnik", "Lovro Kuhar", "1990", "21-hrh", "19",
					categoryRepository.findByName("Fiction"));

			repository.save(b1);
			repository.save(b2);
			repository.save(b3);

		};
	}
}
