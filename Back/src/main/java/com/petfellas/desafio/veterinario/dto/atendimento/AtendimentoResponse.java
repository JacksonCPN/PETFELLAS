package com.petfellas.desafio.veterinario.dto.atendimento;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AtendimentoResponse {

    private Long id;
    private LocalDate data;
    private LocalTime hora;
    private int idade_dia;
    private float peso_dia;
    private float altura_dia;
    private float largura_dia;
    private String diagnostico;
    private String comentarios;
    private String nomeCliente;
    private String nomeVeterinario;
    private String nomeCachorro;
}
