package com.petfellas.desafio.veterinario.config;

import com.petfellas.desafio.veterinario.entities.*;
import com.petfellas.desafio.veterinario.repositories.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Configuration
public class PopularBanco implements CommandLineRunner {

    private final UsuarioRepository usuarioRepository;
    private final PerfilRepository perfilRepository;
    private final ClienteRepository clienteRepository;

    private final VeterinarioRepository veterinarioRepository;
    private final AtendimentoRepository atendimentoRepository;

    public PopularBanco(UsuarioRepository usuarioRepository, PerfilRepository perfilRepository, ClienteRepository clienteRepository, VeterinarioRepository veterinarioRepository, AtendimentoRepository atendimentoRepository) {
        this.usuarioRepository = usuarioRepository;
        this.perfilRepository = perfilRepository;
        this.clienteRepository = clienteRepository;
        this.veterinarioRepository = veterinarioRepository;
        this.atendimentoRepository = atendimentoRepository;
    }


    @Override
    public void run(String... args) throws Exception {
        Perfil p1 = new Perfil(null, "VETERINARIO");
        Perfil p2 = new Perfil(null, "CLIENTE");

        List<Perfil> allPerfil = perfilRepository.findAll();
        if(allPerfil.isEmpty()){
            perfilRepository.saveAll(List.of(p1,p2));
        }

        Usuario u1 = new Usuario(null, "veterinario@email.com", new BCryptPasswordEncoder().encode("1234"), p1);
        Usuario u2 = new Usuario(null, "cliente@email.com", new BCryptPasswordEncoder().encode("1234"), p2);

        List<Usuario> allUsuario = usuarioRepository.findAll();
        if(allUsuario.isEmpty()){
            usuarioRepository.saveAll(List.of(u1, u2));
        }

        Endereco enderecoA = new Endereco("Rua A", "1111", "11111111","Próximo a Rua B" );
        Endereco enderecoB = new Endereco("Rua B", "2222", "22222222","Próximo a Rua A" );
        Endereco enderecoC = new Endereco("Rua C", "3333", "33333333","Próximo a Rua B" );

        Cliente clienteA = new Cliente(null, "Luiz Felipe", "luizfelipe@email.com", "(81) 999999999", enderecoA, "11111111111", null);
        Cliente clienteB = new Cliente(null, "Luiz", "luiz@email.com", "(81) 999999999", enderecoB, "22222222222", null);

        Cachorro cachorroA = new Cachorro(null, "cachorro a", 1L, 2, (float) 11.3, (float) 8.8, (float) 3.4, clienteA);
        Cachorro cachorroB = new Cachorro(null, "cachorro b", 8L, 7, (float) 16.8, (float) 10.2, (float) 6.1, clienteB);
        Cachorro cachorroC = new Cachorro(null, "cachorro c", 2L, 1, (float) 8.4, (float) 5.9, (float) 2.4, clienteA);

        clienteA.setCachorros(List.of(cachorroA, cachorroC));
        clienteB.setCachorros(List.of(cachorroB));

        List<Cliente> all = clienteRepository.findAll();
        if(all.isEmpty()){
            clienteA = clienteRepository.save(clienteA);
            clienteRepository.save(clienteB);
        }


        Veterinario veterinario = new Veterinario(null, "Guilherme", "guilherme@email.com", "(81) 999999999", enderecoC, "11111111111");

        List<Veterinario> allVet = veterinarioRepository.findAll();
        if(allVet.isEmpty()){
            veterinario = veterinarioRepository.save(veterinario);
        }

        Atendimento atendimento = new Atendimento(null, LocalDate.now(), LocalTime.now(), 3, (float) 11.0, (float) 8.9, (float) 3.3, "Saudavel", "Tudo ok", clienteA, veterinario, cachorroA);

        List<Atendimento> allAtendimento = atendimentoRepository.findAll();
        if(allAtendimento.isEmpty()){
            atendimentoRepository.save(atendimento);
        }
    }
}
