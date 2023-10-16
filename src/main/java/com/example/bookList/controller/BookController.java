package com.example.bookList.controller;

import com.example.bookList.dto.BookDTO;
import com.example.bookList.model.Book;
import com.example.bookList.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("api/v1/readinglist")
public class BookController {

    @Autowired
    private  BookService bookService;


    @GetMapping("/all")
    public List<BookDTO> getAll(){
        List<BookDTO> bookDTOS = bookService.getAll();
        return bookDTOS;
    }

    @GetMapping("/{readerId}/all")
    public List<BookDTO> getAllBooksForReader(@PathVariable long readerId) {
        List<BookDTO> bookDTOS = bookService.getAllBooksForReader(readerId);
        if (bookDTOS.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Nessun libro trovato per l'utente specificato");
        }
        return bookDTOS;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public BookDTO create (@RequestBody BookDTO book){
        return bookService.create(book);
    }

    @PutMapping("/{bookId}")
    public BookDTO update(@PathVariable long bookId,
                              @RequestBody BookDTO updateBook){

        BookDTO updatedBookDTO = bookService.update(bookId, updateBook);
        return updatedBookDTO;
    }



}


