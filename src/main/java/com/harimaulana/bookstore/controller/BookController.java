package com.harimaulana.bookstore.controller;

import com.harimaulana.bookstore.model.Book;
import com.harimaulana.bookstore.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController // anotasi class sebagai rest controller
@RequestMapping("/api/books")
public class BookController {
	@Autowired
	private BookRepository bookRepository;
	
	// get all books
	@GetMapping
	public List<Book> getAllBooks() {
		return bookRepository.findAll();
	}
	
	// get book by id
	@GetMapping("/{id}")
	public ResponseEntity<Book> getBookById(@PathVariable Long id) {
        return bookRepository.findById(id)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }
	
	// Day 0 topics: Control flow
	// filter book
	@GetMapping("/filter/{criteria}")
	public List<Book> filterBooks(@PathVariable String criteria) {
		List<Book> books = bookRepository.findAll();
		switch (criteria.toLowerCase()) {
			case "expensive":
				return books.stream().filter(book -> book.getPrice() > 50.0).toList();
			case "cheap":
				return books.stream().filter(book -> book.getPrice() <= 50.0).toList();
			default: return books;
		}
	}
	
	// Day 0 topics: loops
	@GetMapping("/titles")
	public List<String> getAllTitles() {
		List<Book> books = bookRepository.findAll();
		List<String> titles = new ArrayList<>();
		for (Book book : books) {
			titles.add(book.getTitle());
		}
		return titles;
	}
	
	
	// add book
	@PostMapping
	public Book addBook(@RequestBody Book book) {
		return bookRepository.save(book);
	}
	
	// update book
	@PutMapping("/{id}")
	 public ResponseEntity<Book> updateBook(@PathVariable Long id, @RequestBody Book bookDetails) {
        return bookRepository.findById(id).map(book -> {
            book.setTitle(bookDetails.getTitle());
            book.setAuthor(bookDetails.getAuthor());
            book.setPrice(bookDetails.getPrice());
            return ResponseEntity.ok(bookRepository.save(book));
        }).orElse(ResponseEntity.notFound().build());
    }
	
	// delete book
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteBook(@PathVariable Long id) {
		return bookRepository.findById(id).map(book -> {
			bookRepository.delete(book);
			return ResponseEntity.noContent().build();
		}).orElse(ResponseEntity.notFound().build());
	}
	

}
