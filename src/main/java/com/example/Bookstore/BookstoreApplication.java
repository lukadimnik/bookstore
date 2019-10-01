package com.example.Bookstore;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.Bookstore.domain.Book;
import com.example.Bookstore.domain.BookRepository;
import com.example.Bookstore.domain.Category;
import com.example.Bookstore.domain.CategoryRepository;

import com.example.Bookstore.domain.*;

@SpringBootApplication
public class BookstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(BookRepository repository, CategoryRepository categoryRepository,
			UserRepository userRepository) {
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

			// Create users: admin/admin user/user
			User user1 = new User("user", "$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6", "USER");
			User user2 = new User("admin", "$2a$10$0MMwY.IQqpsVc1jC8u7IJ.2rT8b0Cd3b3sfIBGV2zfgnPGtT4r0.C", "ADMIN");
			userRepository.save(user1);
			userRepository.save(user2);

		};
	}
}
