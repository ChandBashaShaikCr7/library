package com.konic.library.Entity;

import jakarta.persistence.*;

@Entity
@Table(name="books")
public class BookEntity {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private  String author;
    private String category;
    private int totalcopies;
    private int availablecopies;

    public BookEntity() {
    }

    public BookEntity(String title, String author, String category,  int totalCopies) {
        this.title = title;
        this.author = author;
        this.category = category;
        this.totalcopies = totalCopies;
        this.availablecopies = totalCopies; // Initially all available
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getTotalcopies() {
        return totalcopies;
    }

    public void setTotalcopies(int totalcopies) {
        this.totalcopies = totalcopies;
    }

    public int getAvailablecopies() {
        return availablecopies;
    }

    public void setAvailablecopies(int availablecopies) {
        this.availablecopies = availablecopies;
    }
}
