package com.example.bookList.service.impl;

import com.example.bookList.dto.BookDTO;
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
    public BookDTO create(BookDTO book){
        Book bookEntity = bookMapper.toEntity(book);
        Book savedBook = bookRepository.save(bookEntity);
        return bookMapper.toDto(savedBook);
    }

    @Override
    public BookDTO update(Long id, BookDTO updatedBook) {
        Book existingBook = bookRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Libro non trovato con l'ID specificato"));

        existingBook.setTitle(updatedBook.getTitle());
        existingBook.setAuthor(updatedBook.getAuthor());
        existingBook.setDescription(updatedBook.getDescription());
        existingBook.setIsbn(updatedBook.getIsbn());

        existingBook = bookRepository.save(existingBook);

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
}
