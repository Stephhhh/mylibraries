package com.bnpparibas.itg.mylibraries.libraries.infrastructure;

import com.bnpparibas.itg.mylibraries.libraries.domain.library.Library;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LibraryDAO extends JpaRepository<LibraryJPA, Long> {}