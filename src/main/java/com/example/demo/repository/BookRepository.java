package com.example.demo.repository;


import com.example.demo.entity.BookEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends BaseRepository<BookEntity, Integer> {
    List<BookEntity> findAllByBookCatId(int id);
}

