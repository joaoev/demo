package com.estudo.npi.demo.exception;

public record FieldValidationError(
    String field,
    String message
) {
}

