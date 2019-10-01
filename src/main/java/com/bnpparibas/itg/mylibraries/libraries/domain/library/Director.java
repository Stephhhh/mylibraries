package com.bnpparibas.itg.mylibraries.libraries.domain.library;

public class Director {

    private String surname;

    private String name;

    public Director() {}

    public Director(String surname, String name) {
        this.surname = surname;
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public String getName() {
        return name;
    }
}