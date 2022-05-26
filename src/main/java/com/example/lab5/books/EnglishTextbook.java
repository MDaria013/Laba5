package com.example.lab5.books;

public class EnglishTextbook extends Textbook {

    String lеvеl;
    String university;
    String author;

    public EnglishTextbook(String name, String author, String university) {
        super(name);
        this.author = author;
        this.university = university;
        setLеvеl();
        setLanguage("English");
    }

    public String getLеvеl() {
        return lеvеl;
    }

    public String getUniversity() {
        return university;
    }

    public String getAuthor(){
        return author;
    }

    public void setLеvеl() {
        if (Math.random()<0.5){
            this.lеvеl = "Master";
        } else {
            this.lеvеl = "Bachelor";
        }
    }

}

