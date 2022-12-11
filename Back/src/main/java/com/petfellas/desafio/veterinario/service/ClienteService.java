package com.petfellas.desafio.veterinario.service;

import com.petfellas.desafio.veterinario.entities.Cachorro;
import com.petfellas.desafio.veterinario.entities.Cliente;
import com.petfellas.desafio.veterinario.exceptions.EntityNotFoundException;
import com.petfellas.desafio.veterinario.repositories.ClienteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {

    private final ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public List<Cliente> getClientes(){
        return clienteRepository.findAll();
    }

    public Cliente obterPorId(Long id){
        return clienteRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Cliente não encontrado"));
    }

    public List<Cliente> buscarClientePorNome(String parteNome){

        return clienteRepository.findByNomeContainingIgnoreCase(parteNome);
    }


    public Cliente salvarCliente(Cliente cliente){
        cliente.getCachorros().forEach(cachorro -> cachorro.setCliente(cliente));
        return clienteRepository.save(cliente);
    }

    public Cliente atualizarCliente(Cliente cliente, Long id){
        Cliente clienteOriginal = this.obterPorId(id);
        cliente.setId(clienteOriginal.getId());
        cliente.getCachorros().forEach(cachorro -> cachorro.setCliente(cliente));

        for(Cachorro cachorro : cliente.getCachorros()){
            for(Cachorro cachorroOriginal : clienteOriginal.getCachorros()){
                if (cachorro.getNome().equals(cachorroOriginal.getNome())){
                    cachorro.setId(cachorroOriginal.getId());
                } else {
                    cachorro.setCliente(cliente);
                }
            }
        }

        return clienteRepository.save(cliente);
    }

    public void deletarCliente(Long id){
        Cliente cliente = this.obterPorId(id);
        clienteRepository.delete(cliente);
    }
}
