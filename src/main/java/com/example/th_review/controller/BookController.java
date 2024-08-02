package com.example.th_review.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.th_review.model.Book;
import com.example.th_review.repository.BookRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Controller
@RequiredArgsConstructor
@Slf4j
public class BookController {
	private final BookRepository bookRepository;
	
	@GetMapping
	public String mainPage(Model model) {
		log.info("mainPage 접근");
		model.addAttribute("books", bookRepository.findAll());
		return "main";
	}
	
	
	@PostMapping("/")
	public String addBook(@ModelAttribute Book book) {
		log.info("Book 추가");
		bookRepository.save(book);
		log.info("성공");
		return "redirect:/";
	}
	
	
}
