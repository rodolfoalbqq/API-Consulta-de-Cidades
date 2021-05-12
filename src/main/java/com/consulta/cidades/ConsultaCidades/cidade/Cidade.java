package com.consulta.cidades.ConsultaCidades.cidade;


import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import org.springframework.data.geo.Point;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "cidade")
@TypeDefs(value = {
        @TypeDef(name = "point", typeClass = PointType.class)
})
public class Cidade {

    @Id
    private Long id;

    private String nome;

    private Integer uf;

    private Integer ibge;

    @Column(name = "lat_lon")
    private String geolocalizacao;

    @Type(type = "point")
    @Column(name="lat_lon", updatable = false, insertable = false)
    private Point localizacao;

    public Cidade() {
    }



    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public Integer getUf() {
        return uf;
    }

    public Integer getIbge() {
        return ibge;
    }

    public String getGeolocalizacao() {
        return geolocalizacao;
    }

    public Point getLocalizacao() {
        return localizacao;
    }
}
