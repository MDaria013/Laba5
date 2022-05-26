package com.example.lab5.books;

public abstract class Book {

    protected String title;
    protected String type;
    protected String language;

    protected Book(String title) {
        this.title = title;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getType(){
        return type;
    }
    public String getName() {
        return title;
    }
    public String getLanguage() {
        return language;
    }

}
