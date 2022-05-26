package com.example.lab5.users;

import com.example.lab5.books.Book;
import java.util.ArrayList;


public class UserFactory {
    ReadingUser reading;
    GeneratorUser generatorUser = new GeneratorUser();

    public UserFactory(ReadingUser reading) {
        this.reading = reading;
    }

    public User createUser(ArrayList<Book> booksList) {
        User us;
        if (Math.random()> 0.3) {
            us = CreateStudents();
        }else us = CreateTeachers();

        us.setBooks(generatorUser.GeneratorBooks(booksList));
        return us;
    }

    public Student CreateStudents(){
        Student student=null;
        for (int i=0; i<50; i++){
            double rn=Math.random();
            if (rn>0.6)
                student = new Student(generatorUser.Generator(reading.getFemale_name()), generatorUser.GeneratorFemale_Surname(reading.getMale_Surname()),generatorUser.GeneratorGroup());
            else
                student = new Student(generatorUser.Generator(reading.getMale_name()), generatorUser.Generator(reading.getMale_Surname()),generatorUser.GeneratorGroup());
        }
        return student;
    }

    public Teacher CreateTeachers(){
        Teacher teacher=null;
        for (int i=0; i<40; i++){
            double rn=Math.random();
            if (rn>0.5)
                teacher = new Teacher(generatorUser.Generator(reading.getMale_name()),generatorUser.Generator(reading.getTMale_Surname()),generatorUser.Generator(reading.getPatronymic()));
            else
                teacher = new Teacher(generatorUser.Generator(reading.getFemale_name()),generatorUser.GeneratorFemale_Surname(reading.getTMale_Surname()),generatorUser.GeneratorFemale_patronomyc(reading.getPatronymic()));
        }
        return teacher;
    }

}
