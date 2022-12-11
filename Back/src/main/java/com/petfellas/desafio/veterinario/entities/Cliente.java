package com.petfellas.desafio.veterinario.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "tb_cliente")
public class Cliente extends Pessoa{

    private String cpf;

    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)
    private List<Cachorro> cachorros;

    public Cliente(Long id, String nome, String email, String telefone, Endereco endereco, String cpf, List<Cachorro> cachorros) {
        super(id, nome, email, telefone, endereco);
        this.cpf = cpf;
        this.cachorros = cachorros;
    }
}
