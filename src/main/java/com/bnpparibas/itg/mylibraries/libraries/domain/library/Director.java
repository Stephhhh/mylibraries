package com.bnpparibas.itg.mylibraries.libraries.domain.library;

import com.bnpparibas.itg.mylibraries.libraries.domain.ddd.DDD;
import com.bnpparibas.itg.mylibraries.libraries.domain.exception.ErrorCodes;
import com.bnpparibas.itg.mylibraries.libraries.domain.exception.ValidationException;
import org.springframework.util.StringUtils;

import java.util.Objects;

@DDD.ValueObject
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
            throw new ValidationException(ErrorCodes.LIBRARY_MUST_HAVE_A_DIRECTOR);
        }
    }

    public String getSurname() {
        return surname;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Director director = (Director) o;
        return surname.equals(director.surname) &&
                name.equals(director.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(surname, name);
    }
}