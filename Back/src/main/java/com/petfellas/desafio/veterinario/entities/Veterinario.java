package com.petfellas.desafio.veterinario.entities;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Table;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "tb_veterinario")
public class Veterinario extends Pessoa{

    private String num_registro;

    public Veterinario(Long id, String nome, String email, String telefone, Endereco endereco, String num_registro) {
        super(id, nome, email, telefone, endereco);
        this.num_registro = num_registro;
    }
}
