package com.example.demo.repository;

import com.example.demo.entity.BaseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.io.Serializable;

public interface BaseRepository<T extends BaseEntity, ID extends Serializable>
        extends JpaRepository<T,ID>, JpaSpecificationExecutor<T> {
}
