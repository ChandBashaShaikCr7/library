package com.konic.library.Controller;

import com.konic.library.Entity.BookEntity;
import com.konic.library.Exception.BookNotFoundException;
import com.konic.library.Service.BookService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/books")
public class BookController {
    @Autowired
    private BookService bookservice;

    @PostMapping("/add")
    public BookEntity addBook(@RequestBody BookEntity book) {
        log.info("Adding book: {}", book);
        return bookservice.addBook(book);
    }
    @GetMapping("/all")
    public List<BookEntity> getAllBooks() throws BookNotFoundException {
        log.info("Fetching all books");
        return bookservice.getAllBooks();
    }
    @PutMapping("/update")
    public BookEntity updateBook(@RequestBody BookEntity book) {
        log.info("Updating book: {}", book);
        return bookservice.updateBook(book);
    }
    @DeleteMapping("/delete/{id}")
    public String deleteBook(@PathVariable Long id) throws BookNotFoundException {
        log.info("Deleting book with id: {}", id);
        bookservice.deleteBook(id);
        return "Deleted Successfully";
    }
    @PostMapping("/addMultiple")
    public List<BookEntity> addMultipleBooks(@RequestBody List<BookEntity> books){
        log.info("Adding multiple books: {}", books);
        return bookservice.addMultipleBooks(books);
    }
    @DeleteMapping("/deleteMultiple")
   public String deleteMultipleBooks(@RequestBody List<Long> ids) throws BookNotFoundException {
        log.info("Deleting multiple books: {}", ids);
        bookservice.deleteMultipleBooks(ids);
        return "Deleted Successfully";
   }

}
