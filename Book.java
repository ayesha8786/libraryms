package com.application.library.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.*;

import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.*;

// Author-Book, Category-Book,Publisher-Book 

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "books")
public class Book {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "isbn", length = 100, nullable = false, unique = true)
	private String isbn;

	@Column(name = "name", length = 50, nullable = false)
	private String name;

	@Column(name = "desc", length = -250, nullable = false)
	private String desc;

	@ManyToMany(cascade = { CascadeType.ALL })
	@JoinTable(name = "books_authors", joinColumns = { @JoinColumn(name = "book_id") }, inverseJoinColumns = {
			@JoinColumn(name = "author_id") })

	private Set<Author> authors = new HashSet<Author>();

	@ManyToMany(cascade = { CascadeType.ALL })
	@JoinTable(name = "books_categories", joinColumns = { @JoinColumn(name = "book_id") }, inverseJoinColumns = {
			@JoinColumn(name = "category_id") }) // inversejoin col = foreign key
	private Set<Category> categories = new HashSet<Category>();

	@ManyToMany(cascade = { CascadeType.ALL })
	@JoinTable(name = "books_publishers", joinColumns = { @JoinColumn(name = "book_id") }, inverseJoinColumns = {
			@JoinColumn(name = "publisher_id") }) // inversejoin col = foreign key
	private Set<Publisher> publishers = new HashSet<Publisher>();

	public Book(String isbn, String name, String desc) {
		super();
		this.isbn = isbn;
		this.name = name;
		this.desc = desc;
	}

	public void removePublisher(Publisher publisher) {
		this.publishers.remove(publisher); // removing publisher from set
		publisher.getBooks().remove(publisher); // Go to Publisher, get all books and remove that publisher
	}

	public void addPublisher(Publisher publisher) {
		this.publishers.add(publisher);
		publisher.getBooks().add(this);
	}

	public void removeAuthor(Author author) {
		this.authors.remove(author);
		author.getBooks().remove(author);
	}

	public void addAuthor(Author author) {
		this.authors.add(author);
		author.getBooks().add(this);
	}

	public void removeCategory(Category category) {
		this.categories.remove(category);
		category.getBooks().remove(category);
	}

	public void addCategory(Category category) {
		this.categories.add(category);
		category.getBooks().add(this);
	}

}
