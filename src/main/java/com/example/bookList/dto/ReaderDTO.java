package com.example.bookList.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ReaderDTO {

    @Schema(description = "reader's firstname", example = "Tony", requiredMode=Schema.RequiredMode.NOT_REQUIRED)
    private String firstName;
    @Schema(description = "reader's lastname", example = "Effe", requiredMode=Schema.RequiredMode.NOT_REQUIRED)
    private String lastName;
}
