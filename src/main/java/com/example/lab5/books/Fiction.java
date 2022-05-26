package com.example.lab5.books;

public class Fiction extends Book{

    private int Year;
    private String author;

    protected Fiction(String name, String author) {
        super(name);
        this.author = author;
        setYear();
    }

    public int getYear() {
        return Year;
    }

    public String getAuthor(){
        return author;
    }

    public void setYear() {
        int rn=(int)(Math.random()*200)+1800;
        this.Year = rn;
    }

    public String getType(){
        return "Fiction";
    }
}

