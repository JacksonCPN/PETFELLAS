package com.petfellas.desafio.veterinario.dto.endereco;

import com.petfellas.desafio.veterinario.entities.Endereco;

public class EnderecoMapper {

    public static Endereco fromDTO(EnderecoDTO dto){

        return new Endereco(dto.getLogradouro(), dto.getNumero(), dto.getCep(), dto.getComplemento());
    }

    public static EnderecoDTO fromEntity(Endereco endereco){

        return new EnderecoDTO(endereco.getLogradouro(), endereco.getNumero(), endereco.getComplemento(), endereco.getCep());
    }
}
