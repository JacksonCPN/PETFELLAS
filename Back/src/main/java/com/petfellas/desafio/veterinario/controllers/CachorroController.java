package com.petfellas.desafio.veterinario.controllers;

import com.petfellas.desafio.veterinario.dto.cachorro.CachorroMapper;
import com.petfellas.desafio.veterinario.dto.cachorro.CachorroRequest;
import com.petfellas.desafio.veterinario.dto.cachorro.CachorroResponse;
import com.petfellas.desafio.veterinario.entities.Cachorro;
import com.petfellas.desafio.veterinario.service.CachorroService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("v1/cachorros")
public class CachorroController {

    private final CachorroService cachorroService;

    public CachorroController(CachorroService cachorroService) {
        this.cachorroService = cachorroService;
    }

    @GetMapping
    public ResponseEntity<List<CachorroResponse>> buscarCachorros() {
        return ResponseEntity.ok(
                cachorroService
                        .getCachorros()
                        .stream()
                        .map(CachorroMapper::fromEntity)
                        .collect(Collectors.toList())
        );
    }

    @GetMapping("{id}")
    public ResponseEntity<CachorroResponse> obterPorId(@PathVariable Long id){
        return ResponseEntity.ok(CachorroMapper.fromEntity(cachorroService.obterPorId(id)));
    }

    @PostMapping
    public ResponseEntity<CachorroResponse> salvarCachorro(@Valid @RequestBody CachorroRequest cachorroRequest){
        Cachorro cachorro = cachorroService.addDonoCachorro(cachorroRequest);

        return ResponseEntity.ok(CachorroMapper.fromEntity(cachorroService.salvarCachorro(cachorro)));
    }

    @PutMapping("{id}")
    public ResponseEntity<CachorroResponse> editarCachorro(@PathVariable Long id,@Valid @RequestBody CachorroRequest cachorroRequest){
        Cachorro cachorro = cachorroService.addDonoCachorro(cachorroRequest);

        return ResponseEntity.ok(CachorroMapper.fromEntity(cachorroService.atualizarCachorro(cachorro, id)));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<CachorroResponse> deletarCachorro(@PathVariable Long id){
        cachorroService.excluirCachorro(id);

        return ResponseEntity.ok().build();
    }
}
