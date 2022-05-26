package com.example.lab5.books;

public class EnglishFiction extends Fiction {

    public EnglishFiction(String name, String author) {
        super(name, author);
        setYear();
        setLanguage("English");
    }

}