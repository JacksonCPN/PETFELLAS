package com.petfellas.desafio.veterinario.dto.auth;

import com.petfellas.desafio.veterinario.entities.Usuario;

public class UsuarioMapper {

    public static UsuarioDTO fromEntity(Usuario usuario){

        return new UsuarioDTO(usuario.getId(), usuario.getEmail(), usuario.getPerfil().getNome());
    }
}
