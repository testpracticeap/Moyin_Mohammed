package com.BookStore.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.BookStore.model.Books;
import com.BookStore.repository.BooksRepository;

//defining the business logic
@Service
public class BooksService {
	@Autowired
	BooksRepository booksRepository;

//getting all books record by using the method findaAll() of CrudRepository
	public List<Books> getAllBooks() {
		List<Books> books = new ArrayList<Books>();
		booksRepository.findAll().forEach(books1 -> books.add(books1));
		return books;
	}

//getting a specific record by using the method findById() of CrudRepository
	public Books getBooksById(int id) {
		return booksRepository.findById(id).get();
	}

	public void save(Books book) {
		booksRepository.save(book);
	}
	
	public void update(Books book, int id) {
		booksRepository.save(book);
		
	}

	
}