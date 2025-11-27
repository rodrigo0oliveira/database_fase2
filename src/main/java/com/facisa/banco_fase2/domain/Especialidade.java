package com.facisa.banco_fase2.domain;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "especialidade")
public class Especialidade {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String nome;

    @ManyToMany(mappedBy = "especialidades")
    private Set<Medico> medicos;

    public Especialidade(){
    }

    public Especialidade(String nome) {
        this.nome = nome;
    }

    public Integer getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
