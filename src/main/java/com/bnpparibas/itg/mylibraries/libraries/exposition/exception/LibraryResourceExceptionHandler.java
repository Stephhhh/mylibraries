package com.bnpparibas.itg.mylibraries.libraries.exposition.exception;

import com.bnpparibas.itg.mylibraries.libraries.domain.exception.LibraryNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice(basePackages = "com.bnpparibas.itg.mylibraries.libraries")
public class LibraryResourceExceptionHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(LibraryResourceExceptionHandler.class);

    @ResponseBody
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(LibraryNotFoundException.class)
    public String libraryNotFound(LibraryNotFoundException exception) {
        String codeErreur = exception.getErrorCode();
        LOGGER.info("Error {} : {}", codeErreur, exception.getMessage());
        return codeErreur;
    }

}