package com.bnpparibas.itg.mylibraries.libraries.exposition.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.security.RolesAllowed;
import javax.validation.Valid;

@RestController
public class UserController {

    @GetMapping("/user")
    public String getUser(Authentication authentication){
        // Ici on peut passer par le paramètre authentication,
        // mais on peut aussi passer par le SecurityContextHolder
        String name = SecurityContextHolder.getContext().getAuthentication().getName();
        String roles = SecurityContextHolder.getContext().getAuthentication().getAuthorities().toString();

        return "You are " + authentication.getName() + " with role(s) "+authentication.getAuthorities() +"<br/>"+
                "You are " + name + " with role(s) "+roles;
    }

    @GetMapping("/admin")
    @Secured("ROLE_ADMIN") // Pour éviter les if/else sur le rôle
    public String isAdmin(){
        return "Congrats ! You are a certified admin !";
    }


}
