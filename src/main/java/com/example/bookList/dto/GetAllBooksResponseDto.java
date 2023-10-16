package com.example.bookList.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter @Setter
public class GetAllBooksResponseDto {

    private List<BookDTO> books;

}
