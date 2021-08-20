package com.kulpinski.libraryapp.dao.entity;

import com.kulpinski.libraryapp.dao.AppUserRepo;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class TestUser {

    public TestUser(AppUserRepo appUserRepo, PasswordEncoder passwordEncoder){

        AppUser appUserAdmin = new AppUser();
        appUserAdmin.setUsername("admin");
        appUserAdmin.setPassword(passwordEncoder.encode("admin"));
        appUserAdmin.setRole("ROLE_ADMIN");
        appUserRepo.save(appUserAdmin);

        AppUser appUser = new AppUser();
        appUser.setUsername("user");
        appUser.setPassword(passwordEncoder.encode("user"));
        appUser.setRole("ROLE_USER");
        appUserRepo.save(appUser);
    }
}
