package com.alibaba.finnova.sample.Exceptions;

import org.springframework.validation.Errors;

public class BadRequestException extends RuntimeException
{
    private static final long serialVersion = 1L;
    private Errors errors;

    public BadRequestException(String message)
    {
        super(message);
    }
    public BadRequestException(String message, Errors errors) {
        super(message);
        this.errors = errors;
    }

    public Errors getErrors()
    {
        return errors;
    }
}
