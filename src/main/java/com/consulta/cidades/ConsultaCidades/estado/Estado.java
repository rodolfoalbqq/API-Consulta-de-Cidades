package com.consulta.cidades.ConsultaCidades.estado;


import com.vladmihalcea.hibernate.type.json.JsonBinaryType;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="estado")
@TypeDefs({
        @TypeDef(name= "jsonb", typeClass = JsonBinaryType.class)
})
public class Estado {

    @Id
    private Long id;

    private String nome;

    private String uf;

    private Integer ibge;

    private Integer pais;

    @Type(type = "jsonb")
    @Basic(fetch = FetchType.LAZY)
    @Column(columnDefinition = "jsonb")
    private List<Integer> ddd;

    public Estado() {
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getUf() {
        return uf;
    }

    public Integer getIbge() {
        return ibge;
    }

    public Integer getPais() {
        return pais;
    }

    public List<Integer> getDdd() {
        return ddd;
    }
}
