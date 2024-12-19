package com.harimaulana.bookstore.repository;

import com.harimaulana.bookstore.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
