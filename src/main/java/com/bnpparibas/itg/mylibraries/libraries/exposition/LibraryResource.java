package com.bnpparibas.itg.mylibraries.libraries.exposition;

import com.bnpparibas.itg.mylibraries.libraries.application.LibraryService;
import com.bnpparibas.itg.mylibraries.libraries.domain.library.Library;
import com.bnpparibas.itg.mylibraries.libraries.domain.library.Type;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class LibraryResource {

    @Autowired
    private LibraryService libraryService;

    @PostMapping("/libraries")
    @ResponseStatus(HttpStatus.CREATED)
    public Long createLibrary(@RequestBody LibraryDTO libraryDTO) {
        return libraryService.create(LibraryAdapter.transformToLibrary(libraryDTO));
    }

    @GetMapping("/libraries/{libraryId}")
    @ResponseStatus(HttpStatus.OK)
    public Library detailLibrary(@PathVariable("libraryId") Long libraryId) {
        return libraryService.obtain(libraryId);
    }

    @GetMapping("/libraries")
    @ResponseStatus(HttpStatus.OK)
    public List<Library> listAllLibrairies() {
        return libraryService.listAll();
    }

    @PutMapping("/libraries/{libraryId}")
    @ResponseStatus(HttpStatus.OK)
    public void updateLibrary(@PathVariable("libraryId") Long libraryId, @RequestBody Library library) {
        libraryService.update(libraryId, library);
    }

    @DeleteMapping("/libraries/{libraryId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removeLibrary(@PathVariable("libraryId") Long libraryId) {
        libraryService.remove(libraryId);
    }

    @GetMapping("/libraries/type/{type}")
    @ResponseStatus(HttpStatus.OK)
    public List<Library> listAllLibrairiesByType(@PathVariable("type") Type type) {
        return libraryService.listAllByType(type);
    }

    @GetMapping("/libraries/director/surname/{surname}")
    @ResponseStatus(HttpStatus.OK)
    public List<Library> listAllLibrairiesByDirectorName(@PathVariable("surname") String surname) {
        return libraryService.listAllByDirectorName(surname);
    }
}