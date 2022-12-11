package com.petfellas.desafio.veterinario.controllers;

import com.petfellas.desafio.veterinario.dto.veterinario.VeterinarioMapper;
import com.petfellas.desafio.veterinario.dto.veterinario.VeterinarioRequest;
import com.petfellas.desafio.veterinario.dto.veterinario.VeterinarioResponse;
import com.petfellas.desafio.veterinario.service.VeterinarioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("v1/veterinarios")
public class VeterinarioController {

    private final VeterinarioService veterinarioService;

    public VeterinarioController(VeterinarioService veterinarioService) {
        this.veterinarioService = veterinarioService;
    }

    @GetMapping
    public ResponseEntity<List<VeterinarioResponse>> buscarVeterinarios(){
        return ResponseEntity.ok(veterinarioService.getVeterinarios().stream().map(VeterinarioMapper::fromEntity).collect(Collectors.toList()));
    }

    @GetMapping("{id}")
    public ResponseEntity<VeterinarioResponse> obterPorId(@PathVariable Long id){
        return ResponseEntity.ok(VeterinarioMapper.fromEntity(veterinarioService.obterPorId(id)));
    }

    @PostMapping
    public ResponseEntity<VeterinarioResponse> salvarVeterinario(@Valid @RequestBody VeterinarioRequest veterinarioRequest){
        return ResponseEntity.ok(VeterinarioMapper.fromEntity(veterinarioService.salvarVeterinario(VeterinarioMapper.fromDTO(veterinarioRequest))));
    }

    @PutMapping("{id}")
    public ResponseEntity<VeterinarioResponse> editarVeterinario(@PathVariable Long id, @Valid @RequestBody VeterinarioRequest veterinarioRequest){
        return ResponseEntity.ok(VeterinarioMapper.fromEntity(veterinarioService.atuaizarVeterinario(VeterinarioMapper.fromDTO(veterinarioRequest), id)));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<VeterinarioResponse> excluirVeterinario(@PathVariable Long id){
        veterinarioService.excluirVeterinario(id);

        return ResponseEntity.ok().build();
    }
}
