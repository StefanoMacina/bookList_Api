package com.example.bookList.service.impl;

import com.example.bookList.dto.BookDTO;
import com.example.bookList.dto.BooksForReaderResponseDto;

import com.example.bookList.mapper.ReaderMapper;
import com.example.bookList.service.BookService;
import com.example.bookList.service.ReaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReaderServiceimpl implements ReaderService {


    @Autowired
    private BookService bookService;

    @Autowired
    private ReaderMapper readerMapper;



}
