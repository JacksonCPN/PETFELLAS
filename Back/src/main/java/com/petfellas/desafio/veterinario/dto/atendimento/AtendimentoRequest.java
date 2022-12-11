package com.petfellas.desafio.veterinario.dto.atendimento;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AtendimentoRequest {

    @NotNull(message = "A data não pode estár vazia")
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate data;

    @NotNull(message = "A hora não pode estar vazia")
    @JsonFormat(pattern = "HH:mm")
    private LocalTime hora;

    @NotNull(message = "A idade não pode estar vazia")
    private int idade_dia;

    @NotNull(message = "O peso não pode estar vazio")
    private float peso_dia;

    @NotNull(message = "A altura não pode estar vazia")
    private float altura_dia;

    @NotNull(message = "A largura não pode estar vazia")
    private float largura_dia;

    @NotBlank(message = "O diagnostico não pode estar vazio")
    private String diagnostico;

    private String comentarios;

    @NotNull(message = "O cliente não pode estar vazio")
    private Long clienteId;

    @NotNull(message = "O veterinário não pode estar vazio")
    private Long veterinarioId;

    @NotNull(message = "O cachorro não pode estar vazio")
    private Long cachorroId;
}
