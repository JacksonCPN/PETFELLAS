package com.petfellas.desafio.veterinario.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class Endereco {

    private String logradouro;
    private String numero;
    private String cep;
    private String complemento;
}