package com.example.bookList.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.*;

@Getter @Setter
public class BookDTO {

        private String isbn;
        private String title;
        private String author;
        private String description;
        private List<ReaderDTO> readerList;

    }


