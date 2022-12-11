package com.petfellas.desafio.veterinario.exceptions;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BaseException extends RuntimeException{

    private static final long serialVersionUID = -7461723216573927617L;

    private String message;

    public BaseException(String message){
        super(message);
        this.message = message;
    }
}
