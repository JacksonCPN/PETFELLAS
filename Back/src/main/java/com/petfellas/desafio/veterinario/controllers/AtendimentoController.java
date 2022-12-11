package com.petfellas.desafio.veterinario.controllers;

import com.petfellas.desafio.veterinario.dto.atendimento.AtendimentoMapper;
import com.petfellas.desafio.veterinario.dto.atendimento.AtendimentoRequest;
import com.petfellas.desafio.veterinario.dto.atendimento.AtendimentoResponse;
import com.petfellas.desafio.veterinario.entities.Atendimento;
import com.petfellas.desafio.veterinario.entities.Usuario;
import com.petfellas.desafio.veterinario.service.AtendimentoService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("v1/atendimentos")
public class AtendimentoController {

    private final AtendimentoService atendimentoService;

    public AtendimentoController(AtendimentoService atendimentoService) {
        this.atendimentoService = atendimentoService;
    }

    @GetMapping
    public ResponseEntity<List<AtendimentoResponse>> buscarAtendimentos(@AuthenticationPrincipal Usuario logado){
        if (logado.getPerfil().getNome().equals("VETERINARIO")){
            return ResponseEntity.ok(atendimentoService.buscarAtendimentos().stream().map(AtendimentoMapper::fromEntity).collect(Collectors.toList()));
        }

        if (logado.getPerfil().getNome().equals("CLIENTE")){
            return ResponseEntity.ok(atendimentoService.buscarAtendimentosCliente(logado.getEmail()).stream().map(AtendimentoMapper::fromEntity).collect(Collectors.toList()));
        }

        return ResponseEntity.notFound().build();
    }

    @GetMapping("{id}")
    public ResponseEntity<AtendimentoResponse> buscarPorId(@PathVariable Long id, @AuthenticationPrincipal Usuario logado){
        return ResponseEntity.ok(AtendimentoMapper.fromEntity(atendimentoService.buscarPorId(id)));
    }

    @PostMapping
    public ResponseEntity<AtendimentoResponse> salvarAtendimento(@Valid @RequestBody AtendimentoRequest atendimentoRequest){
        Atendimento atendimento = atendimentoService.addEntidades(atendimentoRequest);

        return ResponseEntity.ok(AtendimentoMapper.fromEntity(atendimentoService.salvarAtendimento(atendimento)));
    }

    @PutMapping("{id}")
    public ResponseEntity<AtendimentoResponse> editarAtendimento(@PathVariable Long id,@Valid @RequestBody AtendimentoRequest atendimentoRequest){
        Atendimento atendimento = atendimentoService.addEntidades(atendimentoRequest);

        return ResponseEntity.ok(AtendimentoMapper.fromEntity(atendimentoService.editarAtendimento(atendimento, id)));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<AtendimentoResponse> excluirAtendimento(@PathVariable Long id){
        atendimentoService.excluirAtendimento(id);

        return ResponseEntity.ok().build();
    }
}
