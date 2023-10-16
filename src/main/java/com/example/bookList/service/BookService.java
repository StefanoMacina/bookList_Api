package com.example.bookList.service;

import com.example.bookList.dto.BookDTO;
import com.example.bookList.model.Book;

import java.util.*;

public interface BookService {

    List<BookDTO> getAllBooksForReader(Long readerId);

    BookDTO create(BookDTO book);

    List<BookDTO> getAll();

    BookDTO update(Long id, BookDTO updatedBook);
}
