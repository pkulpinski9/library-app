package com.kulpinski.libraryapp.manager;

import com.kulpinski.libraryapp.dao.AppUserRepo;
import com.kulpinski.libraryapp.dao.BooksRepo;
import com.kulpinski.libraryapp.dao.entity.Books;
import com.kulpinski.libraryapp.dao.entity.AppUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsersManager {
    private AppUserRepo appUserRepo;

    @Autowired
    public UsersManager(AppUserRepo appUserRepo) {
        this.appUserRepo = appUserRepo;
    }

    public Optional<AppUser> findById(Long id){
        return appUserRepo.findById(id);
    }

    public Iterable<AppUser> findAll(){
        return appUserRepo.findAll();
    }

    public AppUser save(AppUser appUser){
        return appUserRepo.save(appUser);
    }

    public void deleteById(Long id){
        appUserRepo.deleteById(id);
    }

}
