package com.kulpinski.libraryapp.api;

import com.kulpinski.libraryapp.security.SecurityConfig;
import com.kulpinski.libraryapp.dao.entity.Books;
import com.kulpinski.libraryapp.manager.BooksManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/users/")

public class UsersApi {

    @GetMapping("/home")
    public String home(){
        return "home view hello";
    }
    @GetMapping("/home2")
    public String home2(){
        return "home2 view hello";
    }
}
