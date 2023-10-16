package com.example.bookList.service.impl;

import com.example.bookList.dto.BookDTO;
import com.example.bookList.dto.BookWithoutReaderDto;
import com.example.bookList.dto.BooksForReaderResponseDto;
import com.example.bookList.mapper.BookMapper;
import com.example.bookList.model.Book;
import com.example.bookList.repository.Bookrepository;
import com.example.bookList.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

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
    public List<BookWithoutReaderDto> getAllBooks() {
        List<Book> books = bookRepository.findAll();
        List<BookWithoutReaderDto> bookWithoutReaderDtos = books.stream()
                .map(book -> {
                    BookWithoutReaderDto dto = new BookWithoutReaderDto();
                    dto.setIsbn(book.getIsbn());
                    dto.setTitle(book.getTitle());
                    dto.setAuthor(book.getAuthor());
                    dto.setDescription(book.getDescription());
                    return dto;
                })
                .collect(Collectors.toList());

        return bookWithoutReaderDtos;
    }

    @Override
    public BooksForReaderResponseDto getAllBooksForReader(long readerId) {
        List<Book> books = bookRepository.findByReaderId(readerId);
        List<BookWithoutReaderDto> bookWithoutReaderDtos = books.stream()
                .map(book -> bookMapper.toBookWithoutReaderDto(book))
                .collect(Collectors.toList());

        BooksForReaderResponseDto responseDto = new BooksForReaderResponseDto();
        responseDto.setBooks(bookWithoutReaderDtos);

        return responseDto;
    }

    @Override
    public BookDTO create(BookDTO book){
        Book bookEntity = bookMapper.toEntity(book);
        Book savedBook = bookRepository.save(bookEntity);
        return bookMapper.toDto(savedBook);
    }

    @Override
    public BookDTO update(long id, BookDTO updatedBook) {
        Book existingBook = bookRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Libro non trovato con l'ID specificato"));
        bookMapper.toDto(existingBook);
        bookRepository.save(existingBook);

        return bookMapper.toDto(existingBook);
    }

    @Override
    public boolean deleteById(long id){
        Optional<Book> book = bookRepository.findById(id);
        if (book.isEmpty())
            return false;
        bookRepository.deleteById(id);
        return true;
    }

    @Override
    public List<BookWithoutReaderDto> searchBooksByTitleOrDescription(String searchTerm, String searchDescription) {
        List<Book> books = bookRepository.findByTitleContainingOrDescriptionContaining(searchTerm, searchDescription);
        return bookMapper.toBookWithoutReaderDtos(books);
    }



}
