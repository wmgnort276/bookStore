create table cart(
    id int auto_increment not null,
    order_time datetime not null,
    user_id int not null,
    PRIMARY KEY (id),
    FOREIGN KEY (user_id) REFERENCES app_user(id)
)