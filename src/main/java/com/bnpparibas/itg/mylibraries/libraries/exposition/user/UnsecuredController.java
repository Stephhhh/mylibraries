package com.bnpparibas.itg.mylibraries.libraries.exposition.user;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/unsecured")
public class UnsecuredController {

    //Permet de récupérer un valeur depuis le fichier de propriété
    @Value("${my.property}")
    private String phrase;

    @Value("${my.time}")
    private String time;

    @GetMapping
    public String urlDesecurisee(){
        return phrase+" Il est "+time+" Ceci est une url qui ne nécessite pas d'authentification";
    }

}
