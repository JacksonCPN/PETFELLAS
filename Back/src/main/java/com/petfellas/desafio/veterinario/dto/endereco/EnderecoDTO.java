package com.petfellas.desafio.veterinario.dto.endereco;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EnderecoDTO {

    @NotBlank(message = "O campo logradouro não pode estar vazio")
    private String logradouro;

    @NotBlank(message = "O campo numero não pode estar vazio")
    private String numero;

    @NotBlank(message = "O campo complemento não pode estar vazio")
    private String complemento;

    @NotBlank(message = "O campo cep não pode estar vazio")
    private String cep;
}
