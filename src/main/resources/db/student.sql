-- auto-generated definition
create table student
(
    id          bigint            not null
        primary key,
    name        varchar(10)       null,
    sex         tinyint default 1 null,
    grade       tinyint           null,
    create_time datetime          null,
    update_time datetime          null,
    create_user bigint            null,
    update_user bigint            null,
    status      tinyint(1)        null,
    is_deleted  tinyint(1)        null
);