package com.petfellas.desafio.veterinario.dto.facadeResponse;

import lombok.Data;

@Data
public class Raca {

    private String id;
    private String name;
    private String temperament;
    private String origin;
    private String life_span;
    private Weight weight;
}
