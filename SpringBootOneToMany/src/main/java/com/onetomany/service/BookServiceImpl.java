package com.onetomany.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onetomany.model.Book;
import com.onetomany.repository.BookRepository;

@Service("bookServiceImpl")
public class BookServiceImpl implements BookService {

	@Autowired
	BookRepository bookRepository;

	@Override
	public Book saveBook(Book book) {
		book = bookRepository.save(book);
		return book;
	}

	@Override
	public Book findByBookId(int bookId) {

		Book book = bookRepository.findByBookId(bookId);
		return book;
	}

}
