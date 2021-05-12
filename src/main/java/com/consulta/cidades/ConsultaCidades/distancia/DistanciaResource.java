package com.consulta.cidades.ConsultaCidades.distancia;

import com.consulta.cidades.ConsultaCidades.distancia.servico.DistanciaServico;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/distancias")
public class DistanciaResource {

    private final DistanciaServico service;
    Logger log = LoggerFactory.getLogger(DistanciaResource.class);

    public DistanciaResource(DistanciaServico service) {
        this.service = service;
    }

    @GetMapping("/by-points")
    public Double byPoints(@RequestParam(name = "from") final Long city1,
                           @RequestParam(name = "to") final Long city2) {
        log.info("byPoints");
        return service.distanceByPointsInMiles(city1, city2);
    }

    @GetMapping("/by-cube")
    public Double byCube(@RequestParam(name = "from") final Long city1,
                         @RequestParam(name = "to") final Long city2) {
        log.info("byCube");
        return service.distanceByCubeInMeters(city1, city2);
    }


}
