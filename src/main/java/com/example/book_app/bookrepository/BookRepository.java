package com.example.book_app.bookrepository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.book_app.model.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
	List<Book> findByTitleContainingOrAuthorContaining(String title, String author);
}
