package com.bnpparibas.itg.mylibraries.libraries.application;

import com.bnpparibas.itg.mylibraries.libraries.domain.library.Library;
import com.bnpparibas.itg.mylibraries.libraries.domain.exception.ErrorCodes;
import com.bnpparibas.itg.mylibraries.libraries.domain.exception.MyAppBookException;
import com.bnpparibas.itg.mylibraries.libraries.domain.library.LibraryRepository;
import com.bnpparibas.itg.mylibraries.libraries.infrastructure.LibraryDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class LibraryService {

    @Autowired
    private LibraryRepository libraryRepository;

    public Long create(Library newLibrary) {
        return this.libraryRepository.save(newLibrary);
    }

    public Library obtain(Long id) {
        return this.libraryRepository.get(id);
    }

    public List<Library> listAll() {
        return this.libraryRepository.findAll();
    }

    public void update(Long id, Library libraryWithNewInformations) {
        Library library = obtain(id);
        library.update(libraryWithNewInformations);
        this.libraryRepository.save(library);
    }

    public void remove(Long id) {
        Library library = obtain(id);
        this.libraryRepository.delete(library);
    }
}