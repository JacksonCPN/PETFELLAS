package com.petfellas.desafio.veterinario.controllers;

import com.petfellas.desafio.veterinario.dto.cliente.ClienteMapper;
import com.petfellas.desafio.veterinario.dto.cliente.ClienteRequest;
import com.petfellas.desafio.veterinario.dto.cliente.ClienteResponse;
import com.petfellas.desafio.veterinario.service.ClienteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("v1/clientes")
public class ClienteController {

    private final ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @GetMapping
    public ResponseEntity<List<ClienteResponse>> buscarClientes(){
        return ResponseEntity.ok(
                clienteService
                        .getClientes()
                        .stream()
                        .map(ClienteMapper::fromEntity)
                        .collect(Collectors.toList())
        );
    }

    @GetMapping("{id}")
    public ResponseEntity<ClienteResponse> obterPorId(@PathVariable Long id){
        return ResponseEntity.ok(ClienteMapper.fromEntity(clienteService.obterPorId(id)));
    }

    @GetMapping("/nome/{parteNome}")
    public ResponseEntity<List<ClienteResponse>> buscarPorNome(@PathVariable String parteNome){
        return ResponseEntity.ok(
                clienteService
                        .buscarClientePorNome(parteNome)
                        .stream()
                        .map(ClienteMapper::fromEntity)
                        .collect(Collectors.toList())
        );
    }

    @PostMapping
    public ResponseEntity<ClienteResponse> salvarCliente(@Valid @RequestBody ClienteRequest clienteRequest){
        return ResponseEntity.ok(ClienteMapper.fromEntity(clienteService.salvarCliente(ClienteMapper.fromDTO(clienteRequest))));
    }

    @PutMapping("{id}")
    public ResponseEntity<ClienteResponse> editarCliente(@PathVariable Long id, @Valid @RequestBody ClienteRequest clienteRequest){
        return ResponseEntity.ok(ClienteMapper.fromEntity(clienteService.atualizarCliente(ClienteMapper.fromDTO(clienteRequest), id)));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<ClienteResponse> excluirCliente(@PathVariable Long id){
        clienteService.deletarCliente(id);

        return ResponseEntity.ok().build();
    }
}
