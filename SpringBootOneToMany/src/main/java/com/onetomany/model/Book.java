package com.onetomany.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;

@Entity
public class Book {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "bookId")
	private int bookId;

	@Column(name = "bookName")
	private String bookName;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "book_id", referencedColumnName = "bookId")
	private Set<Story> storyList = new HashSet<>();

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public Set<Story> getStoryList() {
		return storyList;
	}

	public void setStoryList(Set<Story> storyList) {
		this.storyList = storyList;
	}

	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Book(int bookId, String bookName, Set<Story> storyList) {
		super();
		this.bookId = bookId;
		this.bookName = bookName;
		this.storyList = storyList;
	}

	@Override
	public String toString() {
		return "BookController [bookId=" + bookId + ", bookName=" + bookName + ", storyList=" + storyList + "]";
	}

}
