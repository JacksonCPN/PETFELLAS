package com.petfellas.desafio.veterinario.dto.veterinario;

import com.petfellas.desafio.veterinario.dto.endereco.EnderecoDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VeterinarioRequest {

    @NotBlank(message = "O campo nome não pode estar vazio")
    private String nome;

    @NotBlank(message = "O campo email não pode estar vazio")
    @Email(message = "Digite um email valido")
    private String email;

    @NotBlank(message = "O campo telefone não pode estar vazio")
    private String telefone;

    @NotNull(message = "O campo endereco não pode estar vazio")
    private EnderecoDTO endereco;

    @NotBlank(message = "O campo num_registro não pode estar vazio")
    private String num_registro;
}
