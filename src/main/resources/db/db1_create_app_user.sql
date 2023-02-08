create table app_user(
    id int auto_increment not null,
    password varchar(500) not null,
    user_role varchar(50) not null,
    user_name varchar(255) not null,
    email varchar(255) not null,
    create_time datetime default null,
    modify_time datetime default null,
    user_locked boolean default false,
    user_enabled boolean default false,
    app_user_role varchar(255) default null,
    PRIMARY KEY (id)
)