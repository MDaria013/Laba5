package com.example.lab5.users;

import com.example.lab5.books.Book;

import java.util.HashSet;

public abstract class User {
    public String name;
    public String surname;
    public String group;

    HashSet<Book> books = new HashSet<>();

    public User(String surname, String name) {
        this.name = name;
        this.surname = surname;
    }

    public HashSet getBooks() {
        return books;
    }

    public void setBooks(HashSet books) {
        this.books = books;
    }

    /*public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }*/

    public String getFullName() {
        return name + " " + surname;
    }


}

