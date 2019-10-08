package com.example.Bookstore;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.Bookstore.domain.Book;
import com.example.Bookstore.domain.BookRepository;
import com.example.Bookstore.domain.Category;
import com.example.Bookstore.domain.CategoryRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class BookstoreRepositoryTest {

	@Autowired
	private BookRepository repository;

	@Autowired
	private CategoryRepository catRepository;

	@Test
	public void findByTitleShouldReturnBook() {
		List<Book> books = repository.findByTitle("1984");

		assertThat(books).hasSize(1);
		assertThat(books.get(0).getAuthor()).isEqualTo("George Orwell");
	}

	@Test
	public void createNewBook() {
		Book book = new Book("Animal Farm", "George Orwell", "1950", "77-abc", "33",
				catRepository.findByName("Fantasy"));
		repository.save(book);
		assertThat(book.getId()).isNotNull();
	}

//	@Test
//	public void findByNameShouldReturnCategory() {
//		List<Category> categories = catRepository.findByCategoryName("Fiction");
//
//		assertThat(categories).hasSize(1);
//		assertThat(categories.get(0).getName()).isEqualTo("Fiction");
//	}

	@Test
	public void createNewCategory() {
		Category category = new Category("Crime");
		catRepository.save(category);
		assertThat(category.getId()).isNotNull();
	}
}
