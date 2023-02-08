create table book(
    id int auto_increment not null,
    book_cat_id int not null,
    book_name varchar(255) not null ,
    book_author varchar(255) not null,
    unit_price int not null,
    create_time datetime default null,
    modify_time datetime default null,
    create_by int not null,
    modified_by int not null,
    PRIMARY KEY (id),
    FOREIGN KEY (book_cat_id) REFERENCES book_cat(id)
)