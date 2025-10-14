package com.konic.library.Service;

import com.konic.library.Entity.BookEntity;
import com.konic.library.Repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    @Autowired
    private BookRepository bookrepository;

    public BookEntity addBook(BookEntity book){
        book.setAvailablecopies(book.getTotalcopies());
     return bookrepository.save(book);
    }

   public List<BookEntity> getAllBooks(){
        return bookrepository.findAll();

   }
//   public void updateBook(Long id,book updatedBook){
//       Optional<book> existingBookOptional=bookrepository.findAllById(id);
//   }
    public BookEntity updateBook(BookEntity book){
       return bookrepository.save(book);
    }

   public void deleteBook(Long id){
   bookrepository.deleteById(id);
   }
}
