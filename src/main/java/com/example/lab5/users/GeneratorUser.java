package com.example.lab5.users;

import com.example.lab5.books.Book;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;


public class GeneratorUser {

    public String Generator(String[] arr) {
        Random r = new Random();
        String s = arr[r.nextInt(arr.length)];
        return s;
    }

    public String GeneratorFemale_patronomyc(String[] arr) {
        String patronomyc = Generator(arr);
        String Female_patronomyc = patronomyc.substring(0, patronomyc.length() - 3) + "вна";
        return Female_patronomyc;
    }

    public String GeneratorFemale_Surname(String[] arr) {
        String surname = Generator(arr);
        String Female_Surname = "";
        if (surname.endsWith("в") || surname.endsWith("н")) {
            Female_Surname = surname + "а";
        } else if (surname.endsWith("ий")) {
            Female_Surname = surname.substring(0, surname.length() - 2) + "ая";
        } else {
            Female_Surname = surname;
        }
        return Female_Surname;
    }

    public HashSet GeneratorBooks(ArrayList<Book> booksList) {
        int num = (int) (Math.random()*8)+3;//((max-min)+1))+min
        Random r = new Random();
        HashSet<Book> books = new HashSet<>();
        for (int i = 0; i < num; i++) {
            books.add(booksList.get(r.nextInt(booksList.size())));
        }
        return books;
    }

    public String GeneratorGroup() {
        double rn = Math.random();
        String group = "";
        if (rn > 0 & rn<0.1) {
            group = " - Б18-103";
        } else if (rn >0.1 & rn<0.2) {
            group = " - Б18-602";
        } else if (rn >0.2 & rn<0.3){
            group = " - Б19-904";
        } else if (rn >0.3 & rn<0.4) {
            group = " - M20-994";
        } else if (rn >0.4 & rn<0.5){
            group = " - Б21-103";
        } else if (rn >0.5 & rn<0.6) {
            group = " - Б19-702";
        } else if (rn >0.6 & rn<0.7){
            group = " - Б21-203";
        } else if (rn >0.7 & rn<0.8) {
            group = " - Б20-205";
        } else if (rn >0.8 & rn<0.0){
            group = " - M20-B03";
        } else
            group = " - C21-402";
        return (group);
    }

}

