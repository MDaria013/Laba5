package com.example.lab5.books;

public class Textbook extends Book{
    protected Textbook(String name) {
        super(name);
    }

    public String getType(){
        return "Textbook";
    }
}