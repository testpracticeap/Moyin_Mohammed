package com.BookStore.repository;
import org.springframework.data.repository.CrudRepository;

import com.BookStore.model.Books;
public interface BooksRepository extends CrudRepository<Books, Integer>
{
}
