package com.petfellas.desafio.veterinario.dto.atendimento;

import com.petfellas.desafio.veterinario.entities.Atendimento;

public class AtendimentoMapper {

    public static Atendimento fromDTO(AtendimentoRequest atendimentoRequest){
        return new Atendimento(
                null,
                atendimentoRequest.getData(),
                atendimentoRequest.getHora(),
                atendimentoRequest.getIdade_dia(),
                atendimentoRequest.getPeso_dia(),
                atendimentoRequest.getAltura_dia(),
                atendimentoRequest.getLargura_dia(),
                atendimentoRequest.getDiagnostico(),
                atendimentoRequest.getComentarios(),
                null,
                null,
                null
                );
    }

    public static AtendimentoResponse fromEntity(Atendimento atendimento){
        return new AtendimentoResponse(
                atendimento.getId(),
                atendimento.getData(),
                atendimento.getHora(),
                atendimento.getIdade_dia(),
                atendimento.getPeso_dia(),
                atendimento.getAltura_dia(),
                atendimento.getLargura_dia(),
                atendimento.getDiagnostico(),
                atendimento.getComentarios(),
                atendimento.getCliente().getNome(),
                atendimento.getVeterinario().getNome(),
                atendimento.getCachorro().getNome()
        );
    }
}
