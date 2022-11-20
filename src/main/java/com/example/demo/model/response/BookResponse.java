package com.example.demo.model.response;

import com.example.demo.common.Constants;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookResponse {
    private Integer bookCatId;
    private String bookName;
    private String bookAuthor;
    @JsonFormat(pattern = Constants.DATE_TIME_PARTTERN)
    private LocalDateTime createTime;
    @JsonFormat(pattern = Constants.DATE_TIME_PARTTERN)
    private LocalDateTime modifiedTime;
}
