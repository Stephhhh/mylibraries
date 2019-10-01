package com.bnpparibas.itg.mylibraries.libraries;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class LibraryResource {

    @Autowired
    private LibraryService libraryService;

    @RequestMapping(method = RequestMethod.POST, path = {"/libraries/"})
    @ResponseStatus(HttpStatus.CREATED)
    public Long createLibrary(@RequestBody Library library) {
        return this.libraryService.create(library);
    }

    @RequestMapping(method = RequestMethod.GET, path = {"/libraries/{libraryId}"})
    public Library detailLibrary(@PathVariable("libraryId") Long libraryId) {
        return this.libraryService.obtain(libraryId);
    }

    @RequestMapping(method = RequestMethod.GET, path = {"/libraries/"})
    public List<Library> listAllLibrairies() {
        return this.libraryService.listAll();
    }

    @RequestMapping(method = RequestMethod.PUT, path = {"/libraries/{libraryId}"})
    @ResponseStatus(HttpStatus.OK)
    public void updateLibrary(@PathVariable("libraryId") Long libraryId, @RequestBody Library library) {
        this.libraryService.update(libraryId, library);
    }

    @RequestMapping(method = RequestMethod.DELETE, path = {"/libraries/{libraryId}"})
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removeBook(@PathVariable("libraryId") Long libraryId) {
        this.libraryService.remove(libraryId);
    }

}