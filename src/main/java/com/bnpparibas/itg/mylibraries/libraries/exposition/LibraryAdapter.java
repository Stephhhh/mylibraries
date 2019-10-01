package com.bnpparibas.itg.mylibraries.libraries.exposition;

import com.bnpparibas.itg.mylibraries.libraries.domain.library.Address;
import com.bnpparibas.itg.mylibraries.libraries.domain.library.Director;
import com.bnpparibas.itg.mylibraries.libraries.domain.library.Library;
import com.bnpparibas.itg.mylibraries.libraries.domain.library.Type;
import com.bnpparibas.itg.mylibraries.libraries.domain.library.book.Book;
import com.bnpparibas.itg.mylibraries.libraries.domain.library.book.LiteraryGenre;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public final class LibraryAdapter {

    private LibraryAdapter() {}

    public static Library transformToLibrary(LibraryDTO libraryDTO) {
        Address address = new Address(
                libraryDTO.addressDTO.number,
                libraryDTO.addressDTO.street,
                libraryDTO.addressDTO.postalCode,
                libraryDTO.addressDTO.city
        );

        Director director = new Director(libraryDTO.directorDTO.surname, libraryDTO.directorDTO.name);

        return new Library(libraryDTO.type, address, director, transformToBook(libraryDTO.bookDTOList));
    }

    public static List<Book> transformToBook(List<LibraryDTO.BookDTO> bookDTO) {
        return bookDTO.stream().map(b -> new Book(b.title, b.author, b.numberOfPage, b.literaryGenre)).collect(Collectors.toList());
    }

    public static LibraryDTO adaptToBookDTO(Library library) {
        return new LibraryDTO(library.getType(),
            new LibraryDTO.AddressDTO(library.getAddress().getNumber(),
                library.getAddress().getStreet(),
                library.getAddress().getPostalCode(),
                library.getAddress().getCity()
            ),
            new LibraryDTO.DirectorDTO(
                library.getDirector().getSurname(),
                library.getDirector().getName()
            ),
            LibraryAdapter.adaptToBookListDTO(library.getBooks())
        );
    }

    public static List<LibraryDTO> adaptToLibraryDTO(List<Library> libraries) {
        return libraries.stream().map(LibraryAdapter::adaptToBookDTO).collect(Collectors.toList());
    }

    public static List<LibraryDTO.BookDTO> adaptToBookListDTO(List<Book> books) {
        return books.stream().map(LibraryAdapter::adaptToBookDTO).collect(Collectors.toList());
    }

    public static LibraryDTO.BookDTO adaptToBookDTO(Book book) {
        return new LibraryDTO.BookDTO(
            book.getTitle(),
            book.getAuthor(),
            book.getNumberOfPage(),
            book.getLiteraryGenre()
        );
    }

}