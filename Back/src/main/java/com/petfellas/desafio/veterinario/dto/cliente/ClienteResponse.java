package com.petfellas.desafio.veterinario.dto.cliente;

import com.petfellas.desafio.veterinario.dto.cachorro.CachorroResponse;
import com.petfellas.desafio.veterinario.dto.endereco.EnderecoDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClienteResponse {

    private Long id;
    private String nome;
    private String email;
    private String telefone;
    private EnderecoDTO enderecoDTO;
    private String cpf;
    private List<CachorroResponse> cachorros;
}
