package com.petfellas.desafio.veterinario.exceptions;

public class EntityNotFoundException extends BaseException{
    private static final long serialVersionUID = -6040533476582637173L;

    public EntityNotFoundException(String message) {
        super(message);
    }
}
