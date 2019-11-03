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

			categoryRepository.save(new Category("Science Fiction"));
			categoryRepository.save(new Category("Romance"));
			categoryRepository.save(new Category("Fantasy"));

			Book b1 = new Book("1984", "George Orwell", "1949", "9781234567897", "15",
					categoryRepository.findByName("Science Fiction"));
			Book b2 = new Book("The Lord of the Rings", "J.R.R. Tolkien", "1954", "9781295567897", "30",
					categoryRepository.findByName("Fantasy"));
			Book b3 = new Book("Brave New World", "Aldous Huxley", "1932", "8566234567897", "19",
					categoryRepository.findByName("Science Fiction"));
			Book b4 = new Book("Pride and Prejudice", "Jane Austen", "1813", "8566234563318", "17",
					categoryRepository.findByName("Romance"));

			repository.save(b1);
			repository.save(b2);
			repository.save(b3);
			repository.save(b4);

			// Create users: admin/admin user/user
			User user1 = new User("user", "$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6", "USER");
			User user2 = new User("admin", "$2a$10$0MMwY.IQqpsVc1jC8u7IJ.2rT8b0Cd3b3sfIBGV2zfgnPGtT4r0.C", "ADMIN");
			userRepository.save(user1);
			userRepository.save(user2);

		};
	}
}
