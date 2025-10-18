package com.konic.library.Entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name="books")
@Data
public class BookEntity {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private  String author;
    private String category;
    private int totalcopies;
    private int availablecopies;
}
