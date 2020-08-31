package com.bnpparibas.itg.mylibraries.libraries.domain.library;

import com.bnpparibas.itg.mylibraries.libraries.domain.library.book.Book;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "LIBRARY")
public class Library {

    @Id
    @GeneratedValue
    @Column(name = "ID")
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "TYPE")
    private Type type;

    @Embedded
    private Address address;

    @Embedded
    private Director director;

    @ManyToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST}, fetch = FetchType.LAZY)
    private List<Book> books;

    public Library() {}

    public Library(Type type, Address address, Director director, List<Book> books) {
        this.type = type;
        this.address = address;
        this.director = director;
        this.books = books;
    }

    public void update(Library libraryWithNewInformation) {
        this.type = libraryWithNewInformation.getType();
        this.address = libraryWithNewInformation.getAddress();
        this.director = libraryWithNewInformation.getDirector();
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