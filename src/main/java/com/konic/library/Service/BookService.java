package com.konic.library.Service;

import com.konic.library.Entity.BookEntity;
import com.konic.library.Exception.BookNotFoundException;
import com.konic.library.Repository.BookRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class BookService {
    @Autowired
    private BookRepository bookrepository;

    public BookEntity addBook(BookEntity book) {
        if (book.getTitle() == null || book.getTitle().trim().isEmpty()) {
            throw new IllegalArgumentException("Book title cannot be empty");
        }
        if (book.getAuthor() == null || book.getAuthor().trim().isEmpty()) {
            throw new IllegalArgumentException("Book author cannot be empty");
        }
        if (book.getTotalcopies() <= 0) {
            throw new IllegalArgumentException("Book totalcopies cannot be zero or cannot be Negative");
        }

        log.info("Service: Adding book: {}", book);
        book.setAvailablecopies(book.getTotalcopies());
        return bookrepository.save(book);
    }


public List<BookEntity> getAllBooks() throws BookNotFoundException {
    log.info("Service: Fetching all books");
    List<BookEntity> books = bookrepository.findAll();
    if (books == null || books.isEmpty()) {
        throw new BookNotFoundException("No books found in the library");
    }
    return books;
}

public BookEntity updateBook(BookEntity book){
        if(book.getId()==null){
            throw new IllegalArgumentException("Book id cannot be null");
        }
        if(book.getTitle()==null || book.getTitle().trim().isEmpty()) {
            throw new IllegalArgumentException("Book title cannot be empty");
        }
        if(book.getAuthor()==null || book.getAuthor().trim().isEmpty()) {
            throw new IllegalArgumentException("Book author cannot be empty");
        }
        if(book.getTotalcopies() <= 0){
            throw new IllegalArgumentException("Book totalcopies cannot be zero or cannot be Negative");
        }
    log.info("Service: Updating book: {}", book);
    return bookrepository.save(book);
}

public void deleteBook(Long id) throws BookNotFoundException {
    log.info("Service: Deleting book with id: {}", id);

    if (!bookrepository.existsById(id)) {
        throw new BookNotFoundException("Book with ID " + id + " not found");
    }
    log.info("Service: Deleting book with id: {}", id);
    bookrepository.deleteById(id);
}

public List<BookEntity> addMultipleBooks(List<BookEntity> books){
    if (books == null || books.isEmpty()) {
        throw new IllegalArgumentException("Book list cannot be empty");
    }
    for (BookEntity book : books) {
        if (book.getTitle() == null || book.getTitle().trim().isEmpty()) {
            throw new IllegalArgumentException("Book title cannot be empty");
        }
        if (book.getAuthor() == null || book.getAuthor().trim().isEmpty()) {
            throw new IllegalArgumentException("Book author cannot be empty or Null");
        }
        if (book.getTotalcopies() <= 0) {
            throw new IllegalArgumentException("Book totalcopies must be greater than zero");
        }
        book.setAvailablecopies(book.getTotalcopies());
    }
    log.info("Service: Adding multiple books: {}", books);
    return bookrepository.saveAll(books);
}
public void deleteMultipleBooks(List<Long> ids) throws BookNotFoundException {
    if (ids == null || ids.isEmpty()) {
        throw new IllegalArgumentException("Book ID list cannot be empty");
    }
    for (Long id : ids) {
        if (!bookrepository.existsById(id)) {
            throw new BookNotFoundException("Book with ID " + id + " not found");
        }
    }
    log.info("Service: Deleting multiple books with IDs: {}", ids);
    bookrepository.deleteAllById(ids);
}

}
