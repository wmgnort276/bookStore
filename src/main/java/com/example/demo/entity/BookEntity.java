package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import net.minidev.json.annotate.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity // use for hibernate
@Table(name = "book")
@ToString
public class BookEntity extends BaseEntity{
    private Integer bookCatId;
    private String bookName;
    private String bookAuthor;
//    Check how to map decimal mySql to Java
    private Integer unitPrice;
    private LocalDateTime createTime = LocalDateTime.now();
    private LocalDateTime modifiedTime = LocalDateTime.now();
}
