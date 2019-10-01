package com.bnpparibas.itg.mylibraries.libraries.domain.library;

import com.bnpparibas.itg.mylibraries.libraries.domain.exception.ErrorCodes;
import com.bnpparibas.itg.mylibraries.libraries.domain.exception.MyAppBookException;
import org.springframework.util.StringUtils;

public class Director {

    private String surname;

    private String name;

    public Director() {}

    public Director(String surname, String name) {
        this.surname = surname;
        this.name = name;
    }

    public void validate() {
        if (this == null || StringUtils.isEmpty(this.surname) || StringUtils.isEmpty(this.name ==null)) {
            throw new MyAppBookException(ErrorCodes.LIBRARY_MUST_HAVE_A_DIRECTOR);
        }
    }

    public String getSurname() {
        return surname;
    }

    public String getName() {
        return name;
    }
}