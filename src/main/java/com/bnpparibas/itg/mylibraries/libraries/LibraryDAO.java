package com.bnpparibas.itg.mylibraries.libraries;

import org.springframework.data.jpa.repository.JpaRepository;

public interface LibraryDAO extends JpaRepository<Library, Long> {}