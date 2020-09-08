package com.bnpparibas.itg.mylibraries.libraries.application;

import com.bnpparibas.itg.mylibraries.libraries.domain.ddd.DDD;
import com.bnpparibas.itg.mylibraries.libraries.domain.library.Library;
import com.bnpparibas.itg.mylibraries.libraries.domain.library.LibraryRepository;
import com.bnpparibas.itg.mylibraries.libraries.domain.library.Type;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@DDD.ApplicationService
@Transactional
@Service
public class LibraryService {

    @Autowired
    private LibraryRepository libraryRepository;

    public Long create(Library newLibrary) {
        return libraryRepository.save(newLibrary);
    }

    public Library obtain(Long id) {
        return libraryRepository.get(id);
    }

    public List<Library> listAll() {
        return libraryRepository.findAll();
    }

    public void update(Long id, Library libraryWithNewInformations) {
        Library library = obtain(id);
        library.update(libraryWithNewInformations);
        libraryRepository.save(library);
    }

    public void remove(Long id) {
        Library library = obtain(id);
        libraryRepository.delete(library);
    }

    public List<Library> listAllByType(Type type) {
        return libraryRepository.findLibraryByType(type);
    }

    public List<Library> listAllByDirectorName(String surname) {
        return libraryRepository.findLibraryByDirectorSurname(surname);
    }
}