package com.petfellas.desafio.veterinario.repositories;

import com.petfellas.desafio.veterinario.entities.Perfil;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PerfilRepository extends JpaRepository<Perfil, Long> {
}
