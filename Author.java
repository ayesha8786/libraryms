package com.application.library.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.*;
import com.application.library.entity.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "authors")
public class Author {

	public Author(String name, String desc) {
		super();
		this.name = name;
		this.desc = desc;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "name", length = 100, nullable = false, unique = true)
	private String name;
	@Column(name = "desc", length = 250, nullable = false)
	private String desc;

	@ManyToMany(mappedBy = "authors", cascade = CascadeType.ALL)
	private Set<Book> books = new HashSet<Book>();

}
