package com.example.bookList.service.impl;

import com.example.bookList.dto.BookDTO;
import com.example.bookList.mapper.BookMapper;
import com.example.bookList.model.Book;
import com.example.bookList.repository.Bookrepository;
import com.example.bookList.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class BookServiceImpl implements BookService {
    private final BookMapper bookMapper;
    private final Bookrepository bookRepository;

    @Autowired
    public BookServiceImpl(BookMapper bookMapper, Bookrepository bookRepository) {
        this.bookMapper = bookMapper;
        this.bookRepository = bookRepository;
    }


    @Override
    public List<BookDTO> getAll(){
        List<Book> books = bookRepository.findAll();
        List<BookDTO> bookDTOs = books.stream()
                .map(book -> bookMapper.toDto(book))
                .collect(Collectors.toList());
        return bookDTOs;
    }

    @Override
    public List<BookDTO> getAllBooksForReader(Long readerId) {
        List<Book> books = bookRepository.findByReaderId(readerId);
        List<BookDTO> bookDTOs = books.stream()
                .map(book -> bookMapper.toDto(book))
                .collect(Collectors.toList());
        return bookDTOs;
    }

    @Override
    public Book create(Book book){
        Book bookEntity = bookMapper.toEntity(book);
        return bookRepository.save(bookEntity);
    }

}
