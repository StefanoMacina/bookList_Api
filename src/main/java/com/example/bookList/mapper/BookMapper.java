package com.example.bookList.mapper;

import com.example.bookList.dto.BookDTO;
import com.example.bookList.dto.ReaderDTO;
import com.example.bookList.model.Book;
import com.example.bookList.model.Reader;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class BookMapper {

    public BookDTO toDto(Book book) {
        BookDTO bookDTO = new BookDTO();
        bookDTO.setTitle(book.getTitle());
        bookDTO.setAuthor(book.getAuthor());
        bookDTO.setIsbn(book.getIsbn());
        bookDTO.setDescription(book.getDescription());

        Reader reader = book.getReader();
        if (reader != null) {
            ReaderDTO readerDTO = new ReaderDTO();
            readerDTO.setFirstName(reader.getFirstName());
            readerDTO.setLastName(reader.getLastName());
            bookDTO.setReaderList(Arrays.asList(readerDTO));
        }

        return bookDTO;
    }

    public Book toEntity(BookDTO bookDTO) {
        Book book = new Book();
        book.setIsbn(bookDTO.getIsbn());
        book.setTitle(bookDTO.getTitle());
        book.setAuthor(bookDTO.getAuthor());
        book.setDescription(bookDTO.getDescription());

        return book;
    }
}

