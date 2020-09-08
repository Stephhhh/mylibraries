package com.bnpparibas.itg.mylibraries.libraries.exposition;

import com.bnpparibas.itg.mylibraries.libraries.domain.exception.ErrorCodes;
import com.bnpparibas.itg.mylibraries.libraries.domain.library.Type;
import com.bnpparibas.itg.mylibraries.libraries.domain.library.book.LiteraryGenre;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotNull;
import java.util.Collections;
import java.util.List;

//Here, encapsulation can be debated because the internal structure does not have to be hidden
//and the DTO is not supposed to have any kind of intelligence
public class LibraryDTO {
    @JsonProperty
    final Type type;

    @JsonProperty
    @NotNull
    final AddressDTO addressDTO;

    @NotNull(message = ErrorCodes.LIBRARY_MUST_HAVE_A_DIRECTOR)
    @JsonProperty
    final DirectorDTO directorDTO;

    @JsonProperty
    final List<BookDTO> bookDTOList;

    public LibraryDTO(Type type, AddressDTO addressDTO, DirectorDTO directorDTO, List<BookDTO> bookDTOList) {
        this.type = type;
        this.addressDTO = addressDTO;
        this.directorDTO = directorDTO;
        this.bookDTOList = Collections.unmodifiableList(bookDTOList);
    }

    public static class DirectorDTO {
        @JsonProperty
        final String surname;

        @JsonProperty final String name;

        public DirectorDTO(String surname, String name) {
            this.surname = surname;
            this.name = name;
        }
    }

    public static class AddressDTO {
        @JsonProperty final int number;
        @JsonProperty final String street;
        @JsonProperty final int postalCode;
        @JsonProperty final String city;

        public AddressDTO(int number, String street, int postalCode, String city) {
            this.number = number;
            this.street = street;
            this.postalCode = postalCode;
            this.city = city;
        }
    }

    public static class BookDTO {
        @JsonProperty final String title;
        @JsonProperty final String author;
        @JsonProperty final int numberOfPage;
        @JsonProperty final LiteraryGenre literaryGenre;

        public BookDTO(String title, String author, int numberOfPage, LiteraryGenre literaryGenre) {
            this.title = title;
            this.author = author;
            this.numberOfPage = numberOfPage;
            this.literaryGenre = literaryGenre;
        }
    }
}