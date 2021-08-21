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
@RequestMapping

public class UsersApi {

    private UsersManager usersManager;

    @Autowired
    public UsersApi(UsersManager usersList) {
        this.usersManager = usersList;
    }

    @GetMapping("/home")
    public String home(){
        return "home view hello";
    }
    @GetMapping("/api/users/all")
    public Iterable<AppUser> getAll(){
        return usersManager.findAll();
    }
    @PostMapping("/register")
    public AppUser addUser(@RequestBody AppUser appUser){
        usersManager.addUser(appUser);
        return appUser;
    }
    //@PostMapping
   // public Books addBooks(@RequestBody Books books){
   //     return booksList.save(books);
    //}
}
