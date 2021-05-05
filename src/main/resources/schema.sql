drop table if exists files;

create table files
(
    id integer NOT NULL,
    fileName varchar(100) NOT NULL,
    fileType varchar(50) NOT NULL,
    fileSize integer NOT NULL,
    fileURL varchar(200) NOT NULL,
    primary key (id)
);