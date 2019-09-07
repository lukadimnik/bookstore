package com.example.Bookstore.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
	
	// save a new book
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(Book book) {
		repository.save(book);
		return "redirect:bookList";
	}
	
	// delete a book
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public String deleteBook(@PathVariable("id") Long bookId, Model model) {
	repository.deleteById(bookId);
	return "redirect:../bookList";
	}
	
	// Edit student
	@RequestMapping(value = "/edit/{id}")
	public String addStudent(@PathVariable("id") Long bookId, Model model){
	model.addAttribute("book", repository.findById(bookId));
	return "editBook";
	}

}
