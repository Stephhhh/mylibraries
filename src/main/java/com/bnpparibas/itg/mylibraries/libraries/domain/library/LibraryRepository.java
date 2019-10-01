package com.bnpparibas.itg.mylibraries.libraries.domain.library;

import java.util.List;

public interface LibraryRepository {
    Long save(Library library);
    Library get(Long id);
    List<Library> findAll();
    void delete(Library library);
}