package com.kulpinski.libraryapp.dao.entity;

import com.kulpinski.libraryapp.dao.AppUserRepo;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class TestUser {

    public TestUser(AppUserRepo appUserRepo, PasswordEncoder passwordEncoder){

        AppUser appUser = new AppUser();
        appUser.setUsername("pawel");
        appUser.setPassword(passwordEncoder.encode("123"));
        appUser.setRole("ADMIN");
        appUserRepo.save(appUser);
    }
}
