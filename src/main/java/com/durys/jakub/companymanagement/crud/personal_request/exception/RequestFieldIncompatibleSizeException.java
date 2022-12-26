package com.durys.jakub.companymanagement.crud.personal_request.exception;

public class RequestFieldIncompatibleSizeException extends RuntimeException {

    public final static String MSG = "Incompatible request fields size";

    public RequestFieldIncompatibleSizeException() {
        super(MSG);
    }
}
