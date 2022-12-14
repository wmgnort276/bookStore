package com.example.demo.model.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookRequest {
    private Integer bookCatId;
    private String bookName;
    private String bookAuthor;
    private Integer unitPrice;
}
