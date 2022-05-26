package com.example.lab5.users;

public class Student extends User{

    public Student(String name, String surname,String group) {
        super(name, surname);
        this.group=group;
    }

    @Override
    public String getFullName() {
        return name + " " + surname + " " + group;
    }
}


