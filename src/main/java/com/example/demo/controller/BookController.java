package com.example.demo.controller;

import com.example.demo.business.BookBusiness;
import com.example.demo.entity.BookEntity;
import com.example.demo.model.request.BookRequest;
import com.example.demo.model.response.BookResponse;
import com.example.demo.repository.BookRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.function.EntityResponse;

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
    public List<BookResponse> getAll() {
        return bookBusiness.getAll();
    }

    @GetMapping(value = "/all")
    public String getAllTest() {
        return bookBusiness.getAllTest();
    }

    @GetMapping(value = "/{id}")
    public BookResponse getById(@PathVariable Integer id) {
        return bookBusiness.getByID(id);
    }

    @DeleteMapping(value = "/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public void deleteBook(@PathVariable Integer id) {
        bookBusiness.deleteBook(id);
    }

    //    hasRole('ROLE_') hasAnyRole('ROLE_') hasAuthority('book:modify') hasAnyAuthority('permission')
    @PostMapping
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String insertBook(@RequestBody BookRequest request){
        BookEntity bookEntity = new BookEntity();
        bookEntity.setBookName(request.getBookName());
        bookEntity.setBookCatId(request.getBookCatId());
        bookEntity.setUnitPrice(request.getUnitPrice());
        bookEntity.setBookAuthor(request.getBookAuthor());
        bookEntity.setCreateTime(LocalDateTime.now());
        bookRepository.save(bookEntity);
        return "insert done";
    }
}
