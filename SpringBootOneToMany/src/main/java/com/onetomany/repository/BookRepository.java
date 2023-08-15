package com.onetomany.repository;

import java.io.Serializable;

import org.springframework.data.repository.CrudRepository;

import com.onetomany.model.Book;

public interface BookRepository extends CrudRepository<Book, Serializable> {

	public Book findByBookId(int bookId);
}
