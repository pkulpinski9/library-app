package com.kulpinski.libraryapp.dao.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Books {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    Long id;



    @JsonIgnore
    @ManyToMany
    @JoinTable(
            name="my_books",
            joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    private Set<AppUser> myUsers = new HashSet<>();

    private String title;

    private String category;

    private Long count;

    public Books() {
    }

    public Books(Long id, String title, String category, Long count) {
        this.id = id;
        this.title = title;
        this.category = category;
        this.count = count;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    public Set<AppUser> getMyUsers() {
        return myUsers;
    }

    public void myUsers(AppUser appUser) {
        myUsers.add(appUser);
    }
}
