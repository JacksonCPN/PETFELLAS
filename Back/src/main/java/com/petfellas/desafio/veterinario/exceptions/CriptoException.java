package com.petfellas.desafio.veterinario.exceptions;

public class CriptoException extends RuntimeException {
    public CriptoException(String msg) {
        super(msg);
    }

    private static final long serialVersionUID = 1L;
}
