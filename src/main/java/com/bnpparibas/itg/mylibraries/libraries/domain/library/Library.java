package com.bnpparibas.itg.mylibraries.libraries.domain.library;

import com.bnpparibas.itg.mylibraries.libraries.domain.library.book.Book;

import java.util.List;

public class Library {

    private Long id;

    private Type type;

    private Address address;

    private Director director;

    private List<Book> books;

    public Library() {}

    public Library(Long id, Type type, Address address, Director director, List<Book> books) {
        this.id = id;
        this.type = type;
        this.address = address;
        this.director = director;
        this.books = books;
        validate();
    }

    public void update(Library libraryWithNewInformation) {
        this.type = libraryWithNewInformation.getType();
        this.address = libraryWithNewInformation.getAddress();
        this.director = libraryWithNewInformation.getDirector();
        validate();
    }

    private void validate() {
        this.director.validate();
    }

    public Long getId() {
        return id;
    }

    public Type getType() {
        return type;
    }

    public Address getAddress() {
        return address;
    }

    public Director getDirector() {
        return director;
    }

    public List<Book> getBooks() {
        return books;
    }
}