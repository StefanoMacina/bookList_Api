package com.example.bookList.controller;

import com.example.bookList.dto.BookDTO;
import com.example.bookList.dto.BookWithoutReaderDto;
import com.example.bookList.dto.DefaultErrorDto;
import com.example.bookList.service.BookService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("api/v1/readinglist")
@Tag(name ="Books", description = "Book management APIs")
public class BookController {

    @Autowired
    private  BookService bookService;

    @Operation(summary = "Retrieves all books without reader", description = "Retrieves all books without reader")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved"),
            @ApiResponse(responseCode = "400", description = "One or more parameters are invalid",
                    content = @Content(schema = @Schema(implementation = DefaultErrorDto.class))) })
    @GetMapping("/all")
    public List<BookWithoutReaderDto> getAllBooks(){
        return bookService.getAllBooks();

    }
    @Operation(summary = "Creates a new book", description = "Creates a new book")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Successfully created"),
    })
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public BookDTO create (@RequestBody BookDTO book){
        return bookService.create(book);
    }

    @Operation(summary = "Update a book", description = "Update the book with the given id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully updated"),
            @ApiResponse(
                    responseCode = "404",
                    description = "Not found - The book was not found",
                    content = @Content(schema = @Schema(implementation = DefaultErrorDto.class)))
    } )
    @PutMapping ("/{bookId}")
    public BookDTO update(@PathVariable long bookId,
                              @RequestBody BookDTO updateBook){

        BookDTO updatedBookDTO = bookService.update(bookId, updateBook);
        return updatedBookDTO;
    }

    @Operation(summary = "Delete a book", description = "Delete the book with the given id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Successfully deleted"),
    } )
    @DeleteMapping("/{bookId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable long bookId){
        bookService.deleteById(bookId);
    }


    @Operation(summary = "search a book", description = "search a book by given title or description")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved"),
    } )
    @GetMapping("/search")
    public List<BookWithoutReaderDto> searchBooks(
            @RequestParam(name = "searchTitle") String titleParam,
            @RequestParam(name = "searchDescription") String descritionParam
            ){
        return bookService.searchBooksByTitleOrDescription(titleParam,descritionParam);
    }
}


