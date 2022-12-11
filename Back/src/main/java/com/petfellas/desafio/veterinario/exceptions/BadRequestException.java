package com.petfellas.desafio.veterinario.exceptions;

public class BadRequestException extends BaseException{
    private static final long serialVersionUID = -6040533476582637173L;

    public BadRequestException(String message) {
        super(message);
    }
}
