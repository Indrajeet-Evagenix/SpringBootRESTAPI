package com.onetomany.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.onetomany.model.Book;
import com.onetomany.model.Story;
import com.onetomany.repository.BookRepository;
import com.onetomany.service.BookService;

@RestController
public class BookController {

	@Autowired
	private BookService bookService;
	@Autowired
	private BookRepository bookRepository;

	@PostMapping(value = "/savebook")
	@ResponseBody
	public Book saveBook(@RequestBody Book book) {
		Book bookResponse = bookService.saveBook(book);
		return bookResponse;
	}

	@GetMapping(value = "/getBookById/{bookId}")
	public Book getBookDetails(@PathVariable int bookId) {
		Book book = bookService.findByBookId(bookId);
		return book;
	}

	@GetMapping(value = "/getAllBooks")
	public List<Book> getAllBookDetails() {
		List<Book> list = (List<Book>) bookRepository.findAll();
		return list;
	}

	@GetMapping(value = "/getAllBooksByRaw")
	public Book getAllBookDetailsByRaw(@RequestBody Book book) {
		Integer id = book.getBookId();
		Optional<Book> list = bookRepository.findById(id);
		if (list.isPresent()) {
			System.out.println(list.get());
			return list.get();
		} else {
			return null;
		}

	}

	@DeleteMapping(value = "/deleteBookById/{bookId}")
	public String deleteBookDetails(@PathVariable int bookId) {
		bookRepository.deleteById(bookId);
		return "Book Deleted Successfully";
	}

	@PutMapping(value = "/updateById/{bookId}")
	public String updateBook(@PathVariable int bookId, @RequestBody Book book) {
		Optional<Book> optionalBook = bookRepository.findById(bookId);
		if (optionalBook.isPresent()) {
			Book bk = optionalBook.get();
			bk.setBookName(book.getBookName());
//			Story story=new Story();

			bk.setStoryList(book.getStoryList());
			bookRepository.save(bk);

			return "Book Details Against ID: " + bookId + " Updated";
		} else {
			return "Book Details With this ID: " + bookId + " Not Exist";
		}

	}

}
