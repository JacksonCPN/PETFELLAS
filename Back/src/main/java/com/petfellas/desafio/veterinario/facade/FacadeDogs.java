package com.petfellas.desafio.veterinario.facade;

import com.petfellas.desafio.veterinario.dto.facadeResponse.Raca;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(value= "dogs", url = "https://api.thedogapi.com/v1/")
public interface FacadeDogs {

    @GetMapping(value = "breeds")
    List<Raca> listarRacas(@RequestHeader("x-api-key") String tokenApi);

    @GetMapping(value = "breeds/{id}")
    Raca buscarRacaPorId(@RequestHeader("x-api-key") String tokenApi,
                           @PathVariable(value = "id") Long id);

    @GetMapping(value = "breeds/search")
    List<Raca> filtrarRacas(@RequestHeader("x-api-key") String tokenApi,
                            @RequestParam String q);
}
