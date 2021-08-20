package com.kulpinski.libraryapp.dao.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Rent {
    @GeneratedValue(strategy = GenerationType.AUTO)

    @Id
    private Long id;
    private Long idUser;
    private Long idBooks;


}
