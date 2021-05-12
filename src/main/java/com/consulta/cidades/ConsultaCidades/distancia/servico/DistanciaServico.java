package com.consulta.cidades.ConsultaCidades.distancia.servico;


import java.util.Arrays;
import java.util.List;

import com.consulta.cidades.ConsultaCidades.cidade.Cidade;
import com.consulta.cidades.ConsultaCidades.cidade.CidadeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.geo.Point;
import org.springframework.stereotype.Service;

    @Service
    public class DistanciaServico {

        private final CidadeRepository cityRepository;
        Logger log = LoggerFactory.getLogger(DistanciaServico.class);

        public DistanciaServico(final CidadeRepository cityRepository) {
            this.cityRepository = cityRepository;
        }


        public Double distanceByPointsInMiles(final Long city1, final Long city2) {
            log.info("nativePostgresInMiles({}, {})", city1, city2);
            return cityRepository.distanceByPoints(city1, city2);
        }


        public Double distanceByCubeInMeters(Long city1, Long city2) {
            log.info("distanceByCubeInMeters({}, {})", city1, city2);
            final List<Cidade> cities = cityRepository.findAllById((Arrays.asList(city1, city2)));

            Point p1 = cities.get(0).getLocalizacao();
            Point p2 = cities.get(1).getLocalizacao();

            return cityRepository.distanceByCube(p1.getX(), p1.getY(), p2.getX(), p2.getY());
        }
    }

