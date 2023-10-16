package com.example.bookList.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
public class BookWithoutReaderDto {

    private String isbn;
    private String title;
    private String author;
    private String description;

}
