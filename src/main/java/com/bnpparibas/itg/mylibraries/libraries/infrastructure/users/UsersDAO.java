package com.bnpparibas.itg.mylibraries.libraries.infrastructure.users;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersDAO extends JpaRepository<Users, Long> {
}
