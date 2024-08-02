package com.example.th_review.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.th_review.model.Book;


@Repository
public interface BookRepository extends JpaRepository<Book, Long>{

}
