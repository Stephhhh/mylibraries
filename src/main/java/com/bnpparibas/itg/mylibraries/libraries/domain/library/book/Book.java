package com.bnpparibas.itg.mylibraries.libraries.domain.library.book;

public class Book {

    private Long id;

    private String title;

    private String author;

    private int numberOfPage;

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