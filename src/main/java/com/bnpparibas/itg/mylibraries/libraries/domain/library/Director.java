package com.bnpparibas.itg.mylibraries.libraries.domain.library;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Director {

    @Column(name = "DIRECTOR_SURNAME")
    private String surname;

    @Column(name = "DIRECTOR_NAME")
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