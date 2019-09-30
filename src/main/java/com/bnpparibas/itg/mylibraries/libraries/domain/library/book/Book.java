package com.bnpparibas.itg.mylibraries.libraries.domain.library.book;

import javax.persistence.*;

@Entity(name = "BOOK")
public class Book {

    @Id
    @GeneratedValue
    @Column(name = "ID")
    private Long id;

    @Column(name = "TITLE")
    private String title;

    @Column(name = "AUTHOR")
    private String author;

    @Column(name = "NUMBER_OF_PAGE")
    private int numberOfPage;

    @Enumerated(EnumType.STRING)
    @Column(name = "LITERARY_GENRE")
    private LiteraryGenre literaryGenre;

    private Book() {}

    public Book(Long id, String title, String author, int numberOfPage, LiteraryGenre literaryGenre) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.numberOfPage = numberOfPage;
        this.literaryGenre = literaryGenre;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getNumberOfPage() {
        return numberOfPage;
    }

    public LiteraryGenre getLiteraryGenre() {
        return literaryGenre;
    }
}