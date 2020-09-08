package com.bnpparibas.itg.mylibraries.libraries.domain.exception;

public class ValidationException  extends RuntimeException {
    private static final String ERROR_CODE = ErrorCodes.LIBRARY_MUST_HAVE_A_DIRECTOR;

    public ValidationException(String message) {
        super(message);
    }

    public String getErrorCode() {
        return ERROR_CODE;
    }
}
