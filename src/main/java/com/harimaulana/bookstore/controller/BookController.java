package com.harimaulana.bookstore.controller;

import com.harimaulana.bookstore.model.Book;
import com.harimaulana.bookstore.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
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
