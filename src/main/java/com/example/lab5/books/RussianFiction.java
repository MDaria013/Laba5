package com.example.lab5.books;

public class RussianFiction extends Fiction {
    public RussianFiction(String name, String author) {
        super(name,author);
        setYear();
        setLanguage("Русский");
    }
}