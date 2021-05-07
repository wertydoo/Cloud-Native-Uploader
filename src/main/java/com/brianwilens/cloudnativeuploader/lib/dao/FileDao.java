package com.brianwilens.cloudnativeuploader.lib.dao;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="files")
public class FileDao {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private int id;

    //TODO: Finish this
}
