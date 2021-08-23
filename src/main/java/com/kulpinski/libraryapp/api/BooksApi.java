package com.kulpinski.libraryapp.api;

import com.kulpinski.libraryapp.dao.entity.AppUser;
import com.kulpinski.libraryapp.dao.entity.Books;
import com.kulpinski.libraryapp.manager.BooksManager;
import com.kulpinski.libraryapp.manager.UsersManager;
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
    private UsersManager usersManager;


    public BooksApi(UsersManager usersManager) {
        this.usersManager = usersManager;
    }

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

//    @PutMapping("/return/")
//    public void returnBook(@RequestParam Long index) throws Exception {
//        booksList.returnBook(index);
//    }
//
//    @PutMapping("/rent/")
//    public void sellBook(@RequestParam Long index) throws Exception {
//        booksList.rentBook(index);
//    }

    @PutMapping("/{bookId}/rent/{userId}")
    Books myUsersBookRent(
            @PathVariable Long bookId,
            @PathVariable Long userId
    ){
        Books books = booksList.findById(bookId).get();
        AppUser appUser = usersManager.findById(userId).get();
        Long count = books.getCount() - 1;
        books.setCount(count);
        books.myUsers(appUser);
        return booksList.save(books);

    }

    @DeleteMapping
    public void deleteBooks(@RequestParam Long index){
       booksList.deleteById(index);
    }

}
