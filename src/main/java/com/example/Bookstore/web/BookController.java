package com.example.Bookstore.web;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.Bookstore.domain.Book;
import com.example.Bookstore.domain.BookRepository;
import com.example.Bookstore.domain.CategoryRepository;

@Controller
public class BookController {

	@Autowired
	private BookRepository repository;
	@Autowired
	private CategoryRepository categoryRepository;

	// main page with list of books
	@RequestMapping("/bookList")
	public String index(Model model) {
		model.addAttribute("books", repository.findAll());
		return "bookList";
	}

	// add a new book
	@RequestMapping(value = "/add")
	public String addBook(Model model) {
		model.addAttribute("book", new Book());
		model.addAttribute("categories", categoryRepository.findAll());
		return "addBook";
	}

	// delete a book
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public String deleteBook(@PathVariable("id") Long bookId, Model model) {
		repository.deleteById(bookId);
		return "redirect:../bookList";
	}

	// Edit book
	@RequestMapping(value = "/edit/{id}")
	public String addStudent(@PathVariable("id") Long bookId, Model model) {
		model.addAttribute("book", repository.findById(bookId));
		model.addAttribute("categories", categoryRepository.findAll());
		return "editBook";
	}

	// Update book
//	@PostMapping("/update/{id}")
//	public String updateBook(@PathVariable("id") long id, @Valid Book book, BindingResult result, Model model) {
//		if (result.hasErrors()) {
//			book.setId(id);
//			return "editBook";
//		}
//
//		repository.save(book);
//		model.addAttribute("users", repository.findAll());
//		return "bookList";
//	}

	// save a new book
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(Book book) {
		repository.save(book);
		return "redirect:bookList";
	}

}
