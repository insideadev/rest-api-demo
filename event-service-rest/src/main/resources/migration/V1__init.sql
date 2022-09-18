create table event
(
    id         bigint not null auto_increment,
    title      varchar(255),
    place      varchar(255),
    speaker    varchar(255),
    event_type varchar(255),
    date_time  DATETIME default NOW(),
    primary key (id)
) engine = InnoDB