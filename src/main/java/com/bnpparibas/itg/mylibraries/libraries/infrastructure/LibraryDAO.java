package com.bnpparibas.itg.mylibraries.libraries.infrastructure;

import com.bnpparibas.itg.mylibraries.libraries.domain.Library;
import com.bnpparibas.itg.mylibraries.libraries.domain.Type;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LibraryDAO extends JpaRepository<Library, Long> {

    List<Library> findLibraryByType(Type type);

    List<Library> findLibraryByDirectorSurname(String surname);
}