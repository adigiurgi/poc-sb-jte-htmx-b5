package com.example.webapp.application.domain.exceptions;

public class DomainValidationException extends RuntimeException {
    private final String fieldName;
    private final String message;

    public DomainValidationException(String fieldName, String message) {
        super(message);
        this.fieldName = fieldName;
        this.message = message;
    }

    public String getFieldName() {
        return fieldName;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
