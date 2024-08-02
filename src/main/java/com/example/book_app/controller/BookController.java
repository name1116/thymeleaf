package com.example.book_app.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.book_app.bookrepository.BookRepository;
import com.example.book_app.model.Book;

@Controller
@RequestMapping("/books")
public class BookController {

    private final BookRepository bookRepository;

    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @GetMapping
    public String listBooks(Model model) {
        model.addAttribute("books", bookRepository.findAll());
        return "book/list";
    }

    @GetMapping("/{id}")
    public String viewBook(@PathVariable Long id, Model model) {
        model.addAttribute("book", bookRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid book Id:" + id)));
        return "book/view";
    }

    @GetMapping("/new")
    public String newBookForm(Model model) {
        model.addAttribute("book", new Book());
        return "book/form";
    }

    @PostMapping("/new")
    public String addBook(@ModelAttribute Book book) {
        bookRepository.save(book);
        return "redirect:/books";
    }

    @GetMapping("/search")
    public String searchBooks(@RequestParam String query, Model model) {
        List<Book> searchResults = bookRepository.findByTitleContainingOrAuthorContaining(query, query);
        
        if (searchResults.isEmpty()) {
            return "forward:/books/no-results";
        }
        
        model.addAttribute("books", searchResults);
        return "book/list";
    }

    @GetMapping("/no-results")
    public String noResults() {
        return "book/no-results";
    }
}