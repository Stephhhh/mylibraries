package com.bnpparibas.itg.mylibraries.libraries.infrastructure;

import com.bnpparibas.itg.mylibraries.libraries.domain.library.Type;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LibraryDAO extends JpaRepository<LibraryJPA, Long> {

    List<LibraryJPA> findLibraryByType(Type type);

    List<LibraryJPA> findLibraryByDirectorSurname(String surname);

}