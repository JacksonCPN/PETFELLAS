package com.petfellas.desafio.veterinario.dto.cliente;

import com.petfellas.desafio.veterinario.dto.cachorro.CachorroRequest;
import com.petfellas.desafio.veterinario.dto.endereco.EnderecoDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClienteRequest {

    @NotBlank(message = "O campo nome não pode estar vazio")
    private String nome;

    @NotNull(message = "O campo email não pode estar vazio")
    @Email(message = "Digite um email valido")
    private String email;

    @NotBlank(message = "O campo telefone não pode estar vazio")
    private String telefone;

    @NotNull(message = "O campo endereco não pode estar vazio")
    private EnderecoDTO endereco;

    @NotBlank(message = "O campo cpf não pode estar vazio")
    private String cpf;

    @NotNull(message = "O campo cachorros não pode estar vazio")
    private List<CachorroRequest> cachorros;
}
