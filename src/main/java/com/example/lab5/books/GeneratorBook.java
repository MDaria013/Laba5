package com.example.lab5.books;

import java.util.Random;

public class GeneratorBook {

    public String Generator(String[] arr) {
        Random r = new Random();
        String s = arr[r.nextInt(arr.length)];
        return s;
    }

    public String genNameRusEd(String[] arr) {
        double rn = Math.random();
        String type = "";
        if (rn < 0.3 & rn>0) {
            type = "Учебник по курсу: ";
        } else if (rn < 0.4 & rn>0.3) {
            type = "Методическое пособие. ";
        } else if (rn < 0.65 & rn>0.4) {
            type = "Лабораторный практикум по курсу: ";
        } else if (rn < 0.95 & rn>0.65) {
            type = "Сборник задач. ";
        }else{
            type = "Конспект лекций по курсу: ";
        }
        return (type + Generator(arr));
    }

}
