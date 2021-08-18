package com.kulpinski.libraryapp.manager;

import com.kulpinski.libraryapp.dao.BooksRepo;
import com.kulpinski.libraryapp.dao.entity.Books;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BooksManager {

    private BooksRepo booksRepo;

    @Autowired
    public BooksManager(BooksRepo booksRepo) {
        this.booksRepo = booksRepo;
    }

    public Optional<Books> findById(Long id){
        return booksRepo.findById(id);
    }

    public Iterable<Books> findAll(){
        return booksRepo.findAll();
    }

    public Books save(Books books){
        return booksRepo.save(books);
    }

    public void deleteById(Long id){
        booksRepo.deleteById(id);
    }

    @EventListener(ApplicationReadyEvent.class)
    public void fillDb(){
        save(new Books(1L, "The Hobbit", "Fantasy", 39.99F, 4L));
        save(new Books(2L, "The Witcher", "Fantasy", 24.99F, 7L));
        save(new Books(3L, "Autobiography", "Drama", 19.99F, 3L));

    }
}
