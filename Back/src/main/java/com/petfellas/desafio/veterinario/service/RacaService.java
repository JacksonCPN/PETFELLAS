package com.petfellas.desafio.veterinario.service;

import com.petfellas.desafio.veterinario.dto.facadeResponse.Raca;
import com.petfellas.desafio.veterinario.facade.FacadeDogs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RacaService {

    private static String tokenApi = "2f3329f1-8478-4303-842f-c266d1493b1d";
    @Autowired
    private FacadeDogs facadeDogs;

    public List<Raca> listarRacas(){
        return facadeDogs.listarRacas(tokenApi);
    }

    public List<Raca> filtarRacas(String filtro){
        return facadeDogs.filtrarRacas(tokenApi, filtro);
    }

    public Raca buscarRacaPorId(Long id){
        return facadeDogs.buscarRacaPorId(tokenApi, id);
    }
}
