package com.example.bookList.repository;

import com.example.bookList.dto.BookDTO;
import com.example.bookList.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.*;

public interface Bookrepository extends JpaRepository<Book, Long> {

    List<Book> findByReaderId(Long readerId);
}
