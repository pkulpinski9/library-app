package com.kulpinski.libraryapp.api;

import com.kulpinski.libraryapp.dao.entity.AppUser;
import com.kulpinski.libraryapp.manager.UsersManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping

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
    @GetMapping("/api/users/all")
    public Iterable<AppUser> getAll(){
        return usersList.findAll();
    }
    @GetMapping("/api/users/{userId}")
    public Optional<AppUser> getById(@PathVariable Long userId){
        return usersList.findById(userId);
    }
    @PostMapping("/register")
    public AppUser addUser(@RequestBody AppUser appUser){
        usersList.addUser(appUser);
        return appUser;
    }
}
