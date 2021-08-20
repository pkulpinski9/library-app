package com.kulpinski.libraryapp.api;

import com.kulpinski.libraryapp.dao.entity.AppUser;
import com.kulpinski.libraryapp.manager.UsersManager;
import com.kulpinski.libraryapp.security.SecurityConfig;
import com.kulpinski.libraryapp.dao.entity.Books;
import com.kulpinski.libraryapp.manager.BooksManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")

public class UsersApi {

    private UsersManager usersList;

    @Autowired
    public UsersApi(UsersManager usersList) {
        this.usersList = usersList;
    }

    @GetMapping("/home")
    public String home(){
        return "home view hello";
    }
    @GetMapping("/all")
    public Iterable<AppUser> getAll(){
        return usersList.findAll();
    }
    //@PostMapping
   // public Books addBooks(@RequestBody Books books){
   //     return booksList.save(books);
    //}
}
