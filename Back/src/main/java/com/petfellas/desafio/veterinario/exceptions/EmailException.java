package com.petfellas.desafio.veterinario.exceptions;

public class EmailException extends RuntimeException {
    public EmailException(String msg) {
        super(msg);
    }

    private static final long serialVersionUID = 1L;
}
