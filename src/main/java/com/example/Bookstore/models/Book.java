package com.example.Bookstore.models;

public class Book {

	private String title;
	private String author;
	private String year;
	private String isbn;
	private String price;

	public Book(String title, String author, String year, String isbn, String price) {
		this.title = title;
		this.author = author;
		this.year = year;
		this.isbn = isbn;
		this.price = price;
	}

}