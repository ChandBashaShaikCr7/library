package com.konic.library.Repository;

import com.konic.library.Entity.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<BookEntity, Long>{
}
