package com.bnpparibas.itg.mylibraries.libraries.domain.library;

import com.bnpparibas.itg.mylibraries.libraries.domain.ddd.DDD;

import java.util.List;

@DDD.Repository
public interface LibraryRepository {

    Long save(Library library);

    Library get(Long id);

    List<Library> findAll();

    void delete(Library library);

    List<Library> findLibraryByType(Type type);

    List<Library> findLibraryByDirectorSurname(String surname);
}