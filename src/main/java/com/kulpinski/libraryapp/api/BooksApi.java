package com.kulpinski.libraryapp.api;

import com.kulpinski.libraryapp.dao.entity.Books;
import com.kulpinski.libraryapp.manager.BooksManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/books")
public class BooksApi {


    private BooksManager booksList;

    @Autowired
    public BooksApi(BooksManager booksList) {
        this.booksList = booksList;
    }

    @GetMapping("/all")
    public Iterable<Books> getAll(){
        return booksList.findAll();
    }

    @GetMapping
    public Optional<Books> getById(@RequestParam Long index){
        return booksList.findById(index);
    }

    @PostMapping
    public Books addBooks(@RequestBody Books books){
        return booksList.save(books);
    }

    @PutMapping
    public Books updateBooks(@RequestBody Books books){
        return booksList.save(books);
    }

    @DeleteMapping
    public void deleteBooks(@RequestParam Long index){
       booksList.deleteById(index);
    }

}
