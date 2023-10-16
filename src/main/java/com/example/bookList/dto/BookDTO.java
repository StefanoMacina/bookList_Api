package com.example.bookList.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.util.*;

@Getter @Setter
public class BookDTO {

        @Schema(description = "book isbn", example = "isbn78956851", requiredMode=Schema.RequiredMode.NOT_REQUIRED)
        private String isbn;
        @Schema(description = "Book title", example = "Good economics for hard times", requiredMode=Schema.RequiredMode.NOT_REQUIRED)
        private String title;
        @Schema(description = "Book author", example = "Abhijit Banerjee", requiredMode=Schema.RequiredMode.NOT_REQUIRED)
        private String author;
        @Schema(description = "Book description", example = "book description", requiredMode=Schema.RequiredMode.NOT_REQUIRED)
        private String description;
        @Schema(description = "reader list", example = "", requiredMode=Schema.RequiredMode.NOT_REQUIRED)
        private List<ReaderDTO> readerList;

    }


