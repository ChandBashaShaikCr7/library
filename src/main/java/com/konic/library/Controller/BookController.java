package com.konic.library.Controller;

import com.konic.library.Entity.BookEntity;
import com.konic.library.Service.BookService;
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

    @PutMapping("/update")
    public BookEntity updateBook(@RequestBody BookEntity book) {
        return bookservice.updateBook(book);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteBook(@PathVariable Long id) {
        bookservice.deleteBook(id);
        return "Deleted Successfully";
    }


}
