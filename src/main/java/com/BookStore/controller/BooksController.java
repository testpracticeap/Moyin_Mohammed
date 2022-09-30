package com.BookStore.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.BookStore.model.Books;
import com.BookStore.service.BooksService;

//mark class as Controller
@RestController

public class BooksController {
//autowire the BooksService class
	@Autowired
	BooksService booksService;

//creating a get mapping that retrieves all the books detail from the database 
	@GetMapping("/book")
	private List<Books> getAllBooks() {
		return booksService.getAllBooks();
	}

//creating a get mapping that retrieves the detail of a specific book
	@GetMapping("/book/{bookid}")
	private Books getBooks(@PathVariable("bookid") int bookid) {
		return booksService.getBooksById(bookid);
	}

	@PostMapping("/book/create")
		private Books saveBookData(@RequestBody Books book) {
			booksService.save(book);
			return book;
			
		}
	
	@PutMapping("/book/update")
		private Books updateBookData(@RequestBody Books book) {
		booksService.save(book);
		return book;
	}
	}
	



