package com.consulta.cidades.ConsultaCidades.estado;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/estados")
public class EstadoResource {

    @Autowired
    private EstadoRepository repository;

    @GetMapping
    public List<Estado> estados(){
        return repository.findAll();
    }

}
