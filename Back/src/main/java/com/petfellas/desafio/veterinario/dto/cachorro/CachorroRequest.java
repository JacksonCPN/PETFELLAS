package com.petfellas.desafio.veterinario.dto.cachorro;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CachorroRequest {

    @NotBlank(message = "O campo nome não pode estar vazio")
    private String nome;

    @NotNull(message = "O campo racaId não pode estar vazio")
    private Long racaId;

    @NotNull(message = "O campo idade não pode estar vazio")
    private int idade;

    @NotNull(message = "O campo peso não pode estar vazio")
    private float peso;

    @NotNull(message = "O campo altura não pode estar vazio")
    private float altura;

    @NotNull(message = "O campo largura não pode estar vazio")
    private float largura;

    @NotNull(message = "O campo clienteId não pode estar vazio")
    private Long clienteId;
}
