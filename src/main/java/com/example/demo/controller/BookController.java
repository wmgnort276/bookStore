package com.example.demo.controller;

import com.example.demo.business.BookBusiness;
import com.example.demo.entity.BookEntity;
import com.example.demo.model.response.BookResponse;
import com.example.demo.repository.BookRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@Data
@RequestMapping(value = "/api/v1/product")
public class BookController {
    @Autowired
    private BookBusiness bookBusiness;
    @Autowired
    private BookRepository bookRepository;
    @GetMapping
    public List<BookResponse> getAll(){
        return bookBusiness.getAll();
    }
    @DeleteMapping(value = "/{id}")
    public void deleteBook(@PathVariable Integer id){
        bookBusiness.deleteBook(id);
    }
}
