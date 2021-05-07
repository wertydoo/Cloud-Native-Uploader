drop table if exists files;

create table files
(
    id INT NOT NULL,
    fileName VARCHAR(100) NOT NULL,
    fileType VARCHAR(50) NOT NULL,
    fileSize INT NOT NULL,
    fileURL VARCHAR(200) NOT NULL,
    primary key (id)
);