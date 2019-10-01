package com.bnpparibas.itg.mylibraries.libraries.exposition;

import com.bnpparibas.itg.mylibraries.libraries.domain.library.Type;
import com.bnpparibas.itg.mylibraries.libraries.domain.library.book.LiteraryGenre;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class LibraryDTO {
    @JsonProperty
    Type type;

    @JsonProperty
    AddressDTO addressDTO;

    @JsonProperty
    DirectorDTO directorDTO;

    @JsonProperty
    List<BookDTO> bookDTOList;

    public LibraryDTO(Type type, AddressDTO addressDTO, DirectorDTO directorDTO, List<BookDTO> bookDTOList) {
        this.type = type;
        this.addressDTO = addressDTO;
        this.directorDTO = directorDTO;
        this.bookDTOList = bookDTOList;
    }

    public static class DirectorDTO {
        @JsonProperty String surname;
        @JsonProperty String name;

        public DirectorDTO(String surname, String name) {
            this.surname = surname;
            this.name = name;
        }
    }

    public static class AddressDTO {
        @JsonProperty int number;
        @JsonProperty String street;
        @JsonProperty int postalCode;
        @JsonProperty String city;

        public AddressDTO(int number, String street, int postalCode, String city) {
            this.number = number;
            this.street = street;
            this.postalCode = postalCode;
            this.city = city;
        }
    }

    public static class BookDTO {
        @JsonProperty String title;
        @JsonProperty String author;
        @JsonProperty int numberOfPage;
        @JsonProperty LiteraryGenre literaryGenre;

        public BookDTO(String title, String author, int numberOfPage, LiteraryGenre literaryGenre) {
            this.title = title;
            this.author = author;
            this.numberOfPage = numberOfPage;
            this.literaryGenre = literaryGenre;
        }
    }
}