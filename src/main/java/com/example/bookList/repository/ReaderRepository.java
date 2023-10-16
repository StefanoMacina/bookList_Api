package com.example.bookList.repository;

import com.example.bookList.dto.BookWithoutReaderDto;
import com.example.bookList.model.Book;
import com.example.bookList.model.Reader;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.List;
@Repository
public interface ReaderRepository extends JpaRepository<Reader, Long> {
}
