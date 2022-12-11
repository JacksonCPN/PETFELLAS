package com.petfellas.desafio.veterinario.controllers;

import com.petfellas.desafio.veterinario.dto.facadeResponse.Raca;
import com.petfellas.desafio.veterinario.service.RacaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("v1/racas")
public class RacaController {

    private final RacaService racaService;

    public RacaController(RacaService racaService) {
        this.racaService = racaService;
    }

    @GetMapping
    public ResponseEntity<List<Raca>> buscarRacas(){
        return ResponseEntity.ok(racaService.listarRacas());
    }

    @GetMapping("pesquisar")
    public ResponseEntity<List<Raca>> filtrarRacas(@RequestParam String nome){
        return ResponseEntity.ok(racaService.filtarRacas(nome));
    }

    @GetMapping("{id}")
    public ResponseEntity<Raca> buscarRacaPorId(@PathVariable Long id){
        return ResponseEntity.ok(racaService.buscarRacaPorId(id));
    }
}
