package com.bnpparibas.itg.mylibraries.libraries.domain.library;

import com.bnpparibas.itg.mylibraries.libraries.domain.ddd.DDD;
import com.bnpparibas.itg.mylibraries.libraries.domain.library.book.Book;

import java.util.Collections;
import java.util.List;

@DDD.Entity
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
        return Collections.unmodifiableList(books);
    }

    @Override public boolean equals(Object obj) {
        if(obj == null) {
            return false;
        }

        if(!this.getClass().isAssignableFrom(obj.getClass())) {
            return false;
        }

        Library that = this.getClass().cast(obj);

        return that.id.equals(this.id);
    }

    @Override public int hashCode() {
        return this.id.hashCode();
    }

    @Override public String toString() {
        return String.format("%s{id:%s)", this.getClass().getSimpleName(), id);
    }
}