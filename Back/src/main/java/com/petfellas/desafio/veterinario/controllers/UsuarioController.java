package com.petfellas.desafio.veterinario.controllers;

import com.petfellas.desafio.veterinario.dto.auth.UsuarioDTO;
import com.petfellas.desafio.veterinario.dto.auth.UsuarioMapper;
import com.petfellas.desafio.veterinario.entities.Usuario;
import com.petfellas.desafio.veterinario.service.UsuarioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("v1/usuarios")
public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping
    public ResponseEntity<UsuarioDTO> cadastrar(@RequestBody Usuario usuario) throws Exception {
        return ResponseEntity.ok(UsuarioMapper.fromEntity(usuarioService.salvarUsuario(usuario)));
    }
}
