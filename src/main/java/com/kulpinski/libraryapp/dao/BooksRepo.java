package com.kulpinski.libraryapp.dao;

import com.kulpinski.libraryapp.dao.entity.Books;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface BooksRepo extends CrudRepository<Books, Long> {

}
