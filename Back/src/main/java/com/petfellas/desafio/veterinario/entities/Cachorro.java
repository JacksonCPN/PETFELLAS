package com.petfellas.desafio.veterinario.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_cachorro")
public class Cachorro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private Long racaId;
    private int idade;
    private float peso;
    private float altura;
    private float largura;

    @ManyToOne
    private Cliente cliente;

}
