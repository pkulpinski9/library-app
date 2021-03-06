package com.kulpinski.libraryapp.dao;

import com.kulpinski.libraryapp.dao.entity.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AppUserRepo extends CrudRepository<AppUser, Long> {

    Optional<AppUser> findByUsername(String username);

}
