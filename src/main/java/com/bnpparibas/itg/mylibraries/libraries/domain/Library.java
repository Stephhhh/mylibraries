package com.bnpparibas.itg.mylibraries.libraries.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
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

    public Library() {}

    public Library(Long id, Type type, Address address, Director director) {
        this.id = id;
        this.type = type;
        this.address = address;
        this.director = director;
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
}