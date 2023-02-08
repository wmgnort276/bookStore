create table confirmation_token(
    id int auto_increment not null,
    user_id int not null,
    token varchar(255) not null,
    create_time datetime default null,
    expired_time datetime default null,
    confirm_at datetime default null,
    PRIMARY KEY (id),
    FOREIGN KEY (user_id) REFERENCES app_user(id)
)