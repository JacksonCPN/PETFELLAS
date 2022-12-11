package com.petfellas.desafio.veterinario.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_atendimento")
public class Atendimento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate data;
    private LocalTime hora;
    private int idade_dia;
    private float peso_dia;
    private float altura_dia;
    private float largura_dia;
    private String diagnostico;
    private String comentarios;

    @OneToOne
    private Cliente cliente;

    @OneToOne
    private Veterinario veterinario;

    @OneToOne
    private Cachorro cachorro;
}
