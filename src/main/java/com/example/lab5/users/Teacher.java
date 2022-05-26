package com.example.lab5.users;

public class Teacher extends User {
    private String patronymic;

    public Teacher(String name, String surname, String patronymic) {
        super(name, surname);
        this.patronymic = patronymic;
    }

    @Override
    public String getFullName() {
        return name + " " + surname + " " + patronymic;
    }
}
