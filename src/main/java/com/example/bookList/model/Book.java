package com.example.bookList.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "books") @Getter @Setter @NoArgsConstructor
public class Book {

    @Column(name = "isbn")
    private String isbn;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "reader_id")
    private Reader reader;

    @Column(name = "title")
    private String title;

    @Column(name = "author")
    private String author;

    @Column(name = "description")
    private String description;

    public Book(Reader reader, String isbn, String title, String author, String description) {
        this.reader = reader;
        this.title = title;
        this.author = author;
        this.description = description;
        this.isbn = isbn;
    }


}
