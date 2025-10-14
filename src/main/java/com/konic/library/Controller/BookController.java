package com.konic.library.Controller;

import com.konic.library.Entity.BookEntity;
import com.konic.library.Service.BookService;
import com.konic.library.Repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {
    @Autowired
    private BookService bookservice;

    @PostMapping("/add")
    public BookEntity addBook(@RequestBody BookEntity book) {
        return bookservice.addBook(book);
    }
    @GetMapping("/all")
    public List<BookEntity> getAllBooks() {
        return bookservice.getAllBooks();
    }

    public void updateBook() {

    }

    public void deleteBook() {

    }
}
