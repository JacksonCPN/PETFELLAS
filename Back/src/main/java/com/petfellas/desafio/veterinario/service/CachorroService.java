package com.petfellas.desafio.veterinario.service;

import com.petfellas.desafio.veterinario.dto.cachorro.CachorroRequest;
import com.petfellas.desafio.veterinario.entities.Cachorro;
import com.petfellas.desafio.veterinario.entities.Cliente;
import com.petfellas.desafio.veterinario.exceptions.EntityNotFoundException;
import com.petfellas.desafio.veterinario.repositories.CachorroRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CachorroService {

    private final CachorroRepository cachorroRepository;
    private final ClienteService clienteService;

    public CachorroService(CachorroRepository cachorroRepository, ClienteService clienteService) {
        this.cachorroRepository = cachorroRepository;
        this.clienteService = clienteService;
    }

    public List<Cachorro> getCachorros(){
        return cachorroRepository.findAll();
    }

    public Cachorro obterPorId(Long id){
        return cachorroRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Cachorro não encontrado"));
    }

    public Cachorro salvarCachorro(Cachorro cachorro){
        return cachorroRepository.save(cachorro);
    }

    public Cachorro atualizarCachorro(Cachorro cachorro, Long id){
        Cachorro cachorroOriginal = this.obterPorId(id);
        cachorro.setId(cachorroOriginal.getId());

        return cachorroRepository.save(cachorro);
    }

    public void excluirCachorro(Long id){
        Cachorro cachorro = this.obterPorId(id);
        cachorroRepository.delete(cachorro);
    }

    public Cachorro addDonoCachorro(CachorroRequest cachorroRequest){
        Cliente cliente = clienteService.obterPorId(cachorroRequest.getClienteId());

        return new Cachorro(null, cachorroRequest.getNome(), cachorroRequest.getRacaId(), cachorroRequest.getIdade(), cachorroRequest.getPeso(), cachorroRequest.getAltura(), cachorroRequest.getLargura(), cliente);
    }
}
