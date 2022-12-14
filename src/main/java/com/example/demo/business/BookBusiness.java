package com.example.demo.business;


import com.example.demo.entity.BookEntity;
import com.example.demo.model.request.BookRequest;
import com.example.demo.model.response.BookResponse;
import com.example.demo.model.response.BookResponseFilter;
import com.example.demo.repository.BookRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Component
@Data
public class BookBusiness extends BaseBusiness {
    @Autowired
    private final BookRepository bookRepository;

    public List<BookResponse> getAll() {
        List<BookEntity> bookEntityList = bookRepository.findAll();
        List<BookResponse> bookResponseList = mapper.mapAsList(bookEntityList, BookResponse.class);
        return bookResponseList;
    }

    public BookResponse getByID(Integer id) {
        BookEntity bookEntity = bookRepository.findById(id).orElseThrow(
                () -> new IllegalStateException("Not found")
        );
        BookResponse bookResponse = mapper.map(bookEntity, BookResponse.class);
        return bookResponse;
    }

    public BookResponseFilter filter() {

        return null;
    }

    public void deleteBook(Integer id) {
        boolean exist = bookRepository.existsById(id);
        if (!exist) {
            throw new IllegalStateException("Book with id " + id + " does not exist!");
        }
        bookRepository.deleteById(id);
    }

    @Transactional
    public BookResponse updateBook(Integer id, BookRequest bookRequest) {
        BookEntity bookEntity = bookRepository.findById(id).orElseThrow(
                () -> new IllegalStateException("Not found book with " + id)
        );

//        Check từng điều kiện khi update book
//        if(bookRequest.getBookName() != null && bookRequest.getBookName().length() > 0 &&
//            !Objects.equals(bookEntity.getBookName(),bookRequest.getBookName())
//        ) {
//            bookEntity.setBookName(bookRequest.getBookName());
//        }
        bookEntity.setBookName(bookRequest.getBookName());
        bookEntity.setBookAuthor(bookRequest.getBookAuthor());
        bookEntity.setBookCatId(bookRequest.getBookCatId());
        bookEntity.setUnitPrice(bookRequest.getBookCatId());
        bookEntity.setModifiedTime(LocalDateTime.now());
        return mapper.map(bookEntity, BookResponse.class);
    }
}
