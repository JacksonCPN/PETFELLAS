package com.petfellas.desafio.veterinario.dto.cliente;

import com.petfellas.desafio.veterinario.dto.cachorro.CachorroMapper;
import com.petfellas.desafio.veterinario.dto.endereco.EnderecoMapper;
import com.petfellas.desafio.veterinario.entities.Cliente;

import java.util.stream.Collectors;

public class ClienteMapper {

    public static Cliente fromDTO(ClienteRequest clienteRequest){
        return new Cliente(
                null,
                clienteRequest.getNome(),
                clienteRequest.getEmail(),
                clienteRequest.getTelefone(),
                EnderecoMapper.fromDTO(clienteRequest.getEndereco()),
                clienteRequest.getCpf(),
                clienteRequest.getCachorros().stream().map(CachorroMapper::fromDTO).collect(Collectors.toList()));
    }

    public static ClienteResponse fromEntity(Cliente cliente){
        return new ClienteResponse(
                cliente.getId(),
                cliente.getNome(),
                cliente.getEmail(),
                cliente.getTelefone(),
                EnderecoMapper.fromEntity(cliente.getEndereco()),
                cliente.getCpf(),
                cliente.getCachorros().stream().map(CachorroMapper::fromEntity).collect(Collectors.toList())
                );
    }
}
