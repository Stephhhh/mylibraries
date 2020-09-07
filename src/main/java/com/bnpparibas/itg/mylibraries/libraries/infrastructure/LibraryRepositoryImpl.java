package com.bnpparibas.itg.mylibraries.libraries.infrastructure;

import com.bnpparibas.itg.mylibraries.libraries.domain.exception.ErrorCodes;
import com.bnpparibas.itg.mylibraries.libraries.domain.exception.LibraryNotFoundException;
import com.bnpparibas.itg.mylibraries.libraries.domain.library.Library;
import com.bnpparibas.itg.mylibraries.libraries.domain.library.LibraryRepository;
import com.bnpparibas.itg.mylibraries.libraries.domain.library.Type;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class LibraryRepositoryImpl implements LibraryRepository {

    @Autowired
    private LibraryDAO libraryDAO;

    @Override
    public Library get(Long id) {
        return libraryDAO.findById(id).map(LibraryJPA::toLibrary).orElseThrow(() -> new LibraryNotFoundException(ErrorCodes.LIBRARY_NOT_FOUND));
    }

    @Override
    public Long save(Library library) {
        LibraryJPA libraryJPA = libraryDAO.save(new LibraryJPA(library));
        return libraryJPA.getId();
    }

    @Override
    public List<Library> findAll() {
        return libraryDAO.findAll().stream().map(LibraryJPA::toLibrary).collect(Collectors.toList());
    }

    @Override
    public void delete(Library library) {
        libraryDAO.delete(new LibraryJPA(library));
    }

    @Override
    public List<Library> findLibraryByType(Type type) {
        return libraryDAO.findLibraryByType(type)
                .stream()
                .map(LibraryJPA::toLibrary)
                .collect(Collectors.toList());
    }

    @Override
    public List<Library> findLibraryByDirectorSurname(String surname) {
        return libraryDAO.findLibraryByDirectorSurname(surname)
                .stream()
                .map(LibraryJPA::toLibrary)
                .collect(Collectors.toList());
    }
}