package com.example.bookList.service;

import com.example.bookList.dto.BookDTO;

import java.util.*;

public interface BookService {

    List<BookDTO> getAllBooksForReader(Long readerId);
}
