package com.kulpinski.libraryapp.manager;

import com.kulpinski.libraryapp.dao.BooksRepo;
import com.kulpinski.libraryapp.dao.entity.Books;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
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


//    @Transactional
//    public void returnBook(Long id) throws Exception {
//        Books books = booksRepo.findById(id)
//                .orElseThrow(() -> new Exception("Book with id: " + id + " is not found."));
//        Long count = books.getCount() + 1;
//        books.setCount(count);
//        booksRepo.save(books);
//    }
//
//    @Transactional
//    public void rentBook(Long id) throws Exception {
//        Books books = booksRepo.findById(id)
//                .orElseThrow(() -> new Exception("Book with id: " + id + " is not found."));
//        Long count = books.getCount() - 1;
//        if (count < 0) {
//            throw new Exception("Not enough book in store to sell.");
//        }
//        books.setCount(count);
//        booksRepo.save(books);
//    }

    public void deleteById(Long id){
        booksRepo.deleteById(id);
    }

    @EventListener(ApplicationReadyEvent.class)
    public void fillDb(){
        save(new Books(1L, "The Hobbit", "Fantasy", 4L));
        save(new Books(2L, "The Witcher", "Fantasy", 7L));
        save(new Books(3L, "Autobiography", "Drama", 3L));

    }
}
