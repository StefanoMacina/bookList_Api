package com.example.bookList.controller;

import com.example.bookList.dto.BookDTO;
import com.example.bookList.dto.BooksForReaderResponseDto;
import com.example.bookList.dto.DefaultErrorDto;
import com.example.bookList.service.BookService;
import com.example.bookList.service.ReaderService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("api/v1/readinglist")
public class ReaderController {

    @Autowired
    private BookService bookService;

    @Operation(summary = "Retrieves all books for a reader",
            description = "Retrieves all books for the given reader id with reader datas")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Successfully retrieved"),
            @ApiResponse(responseCode = "400", description = "One or more parameters are invalid",
                    content = @Content(schema = @Schema(implementation = DefaultErrorDto.class))) })
    @GetMapping("/{readerId}/all")
    public BooksForReaderResponseDto getAllBooksForReader(@PathVariable long readerId){
        return bookService.getAllBooksForReader(readerId);
    }

}
