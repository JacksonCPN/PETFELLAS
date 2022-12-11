package com.petfellas.desafio.veterinario.service;

import com.petfellas.desafio.veterinario.entities.Veterinario;
import com.petfellas.desafio.veterinario.exceptions.EntityNotFoundException;
import com.petfellas.desafio.veterinario.repositories.VeterinarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VeterinarioService {

    private final VeterinarioRepository veterinarioRepository;

    public VeterinarioService(VeterinarioRepository veterinarioRepository) {
        this.veterinarioRepository = veterinarioRepository;
    }

    public List<Veterinario> getVeterinarios() {
        return veterinarioRepository.findAll();
    }

    public Veterinario obterPorId(Long id) {
        return veterinarioRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Veterinário não encontrado"));
    }

    public Veterinario salvarVeterinario(Veterinario veterinario){
        return veterinarioRepository.save(veterinario);
    }

    public Veterinario atuaizarVeterinario(Veterinario veterinario, Long id){
        Veterinario veterinarioOriginal = this.obterPorId(id);
        veterinario.setId(veterinarioOriginal.getId());

        return veterinarioRepository.save(veterinario);
    }

    public void excluirVeterinario(Long id){
        Veterinario veterinario = this.obterPorId(id);
        veterinarioRepository.delete(veterinario);
    }
}
