package com.bnpparibas.itg.mylibraries.libraries.infrastructure;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class MyUserDetailsService implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
//      Mécanisme qui permet de récupérer un User au format Spring (=UserDetails)
        return null;
    }
}
