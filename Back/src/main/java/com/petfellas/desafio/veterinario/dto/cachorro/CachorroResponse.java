package com.petfellas.desafio.veterinario.dto.cachorro;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CachorroResponse {

    private Long id;
    private String nome;
    private Long racaId;
    private int idade;
    private float peso;
    private float altura;
    private float largura;
    private String nomeDono;
}
