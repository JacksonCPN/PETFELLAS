package com.petfellas.desafio.veterinario.dto.veterinario;

import com.petfellas.desafio.veterinario.dto.endereco.EnderecoDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VeterinarioResponse {

    private Long id;
    private String nome;
    private String email;
    private String telefone;
    private EnderecoDTO enderecoDTO;
    private String num_registro;
}
