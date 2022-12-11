package com.petfellas.desafio.veterinario.service;

import com.petfellas.desafio.veterinario.entities.Usuario;
import com.petfellas.desafio.veterinario.exceptions.CriptoException;
import com.petfellas.desafio.veterinario.exceptions.EmailException;
import com.petfellas.desafio.veterinario.exceptions.EntityNotFoundException;
import com.petfellas.desafio.veterinario.repositories.UsuarioRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService implements UserDetailsService {
    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return buscarUsuarioPorEmail(username);
    }

    public List<Usuario>buscarTodosOsUsuarios(){
        return usuarioRepository.findAll();
    }

    public Usuario buscarUsuarioPorEmail(String email) {

        Optional<Usuario> optional = usuarioRepository.findByEmail(email);

        if(optional.isEmpty()) {
            throw new UsernameNotFoundException("Usuário não encontrado");
        }

        return optional.get();
    }

    public Usuario buscarUsuarioPorId(Long idUsuario) {
        return usuarioRepository.findById(idUsuario).orElseThrow(() -> new EntityNotFoundException("Usuario não encontrado"));
    }

    public Usuario salvarUsuario(Usuario usuario) throws Exception{
        try {
            if(usuarioRepository.findByEmail(usuario.getEmail()).isPresent()) {
                throw  new EmailException("Já existe um email cadastrado: " + usuario.getUsername());
            }

            usuario.setSenha(new BCryptPasswordEncoder().encode(usuario.getSenha()));
        } catch (Exception e){
            throw new CriptoException("Erro na criptofrafia da senha");
        }

        usuarioRepository.save(usuario);
        return usuario;
    }

    public Usuario atualizarUsuario(Usuario usuario, Long id) throws Exception {
        Usuario usuarioOriginal = buscarUsuarioPorId(id);

        usuario.setId(usuarioOriginal.getId());

        return salvarUsuario(usuario);
    }

    public void excluirUsuario(Long id) {
        Usuario usuario = buscarUsuarioPorId(id);
        usuarioRepository.delete(usuario);
    }
}
