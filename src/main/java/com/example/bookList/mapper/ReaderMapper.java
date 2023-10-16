package com.example.bookList.mapper;

import com.example.bookList.dto.BookDTO;
import com.example.bookList.dto.BookWithoutReaderDto;
import com.example.bookList.model.Book;
import org.springframework.stereotype.Component;

@Component
public class ReaderMapper {
    public BookWithoutReaderDto toBookWithoutReaderDto(BookDTO bookDTO) {
        BookWithoutReaderDto dto = new BookWithoutReaderDto();
        dto.setIsbn(bookDTO.getIsbn());
        dto.setTitle(bookDTO.getTitle());
        dto.setAuthor(bookDTO.getAuthor());
        dto.setDescription(bookDTO.getDescription());
        return dto;
    }
}
