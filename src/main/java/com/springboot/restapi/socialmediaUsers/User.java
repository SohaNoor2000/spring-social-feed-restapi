package com.springboot.restapi.socialmediaUsers;

import java.time.LocalDate;


public class User {
    private int id;
    private String name;
    private LocalDate DateOfBirth;

    public User(int id, String name, LocalDate dateOfBirth) {
        this.id = id;
        this.name = name;
        DateOfBirth = dateOfBirth;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDateOfBirth() {
        return DateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        DateOfBirth = dateOfBirth;
    }

    @Override
    public String toString() {
        return "Users{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", DateOfBirth=" + DateOfBirth +
                '}';
    }
}
