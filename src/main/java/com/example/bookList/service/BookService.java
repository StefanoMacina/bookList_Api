package com.example.bookList.service;

import com.example.bookList.dto.BookDTO;
import com.example.bookList.dto.BookWithoutReaderDto;
import com.example.bookList.dto.BooksForReaderResponseDto;

import java.util.*;

public interface BookService {

    BooksForReaderResponseDto getAllBooksForReader(long readerId);

    BookDTO create(BookDTO book);

    List<BookWithoutReaderDto> getAllBooks();

    BookDTO update(long id, BookDTO updatedBook);

    boolean deleteById(long id);
}
