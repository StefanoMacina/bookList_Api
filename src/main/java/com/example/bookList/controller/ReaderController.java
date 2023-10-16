package com.example.bookList.controller;

import com.example.bookList.dto.BookDTO;
import com.example.bookList.dto.BooksForReaderResponseDto;
import com.example.bookList.service.BookService;
import com.example.bookList.service.ReaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("api/v1/readinglist")
public class ReaderController {

    @Autowired
    private BookService bookService;


    @GetMapping("/{readerId}/all")
    public BooksForReaderResponseDto getAllBooksForReader(@PathVariable long readerId){
        return bookService.getAllBooksForReader(readerId);
    }

}
