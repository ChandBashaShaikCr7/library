package com.konic.library.Service;

import com.konic.library.Entity.BookEntity;
import com.konic.library.Repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Service
@Slf4j
public class BookService {
    @Autowired
    private BookRepository bookrepository;

    public BookEntity addBook(BookEntity book){
        log.info("Service: Adding book: {}", book);
        book.setAvailablecopies(book.getTotalcopies());
     return bookrepository.save(book);
    }

   public List<BookEntity> getAllBooks(){
        log.info("Service: Fetching all books");
        return bookrepository.findAll();

   }

    public BookEntity updateBook(BookEntity book){
        log.info("Service: Updating book: {}", book);
       return bookrepository.save(book);
    }

   public void deleteBook(Long id){
        log.info("Service: Deleting book with id: {}", id);
   bookrepository.deleteById(id);
   }

   public List<BookEntity> addMultipleBooks(List<BookEntity> books){
        log.info("Service: Adding multiple books: {}", books);
       return bookrepository.saveAll(books);
   }
   public void deleteMultipleBooks(List<Long> ids){
        bookrepository.deleteAllById(ids);
   }
}
