package com.facisa.banco_fase2.domain;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.Set;

@Entity()
@Table(name = "convenio")
public class Convenio {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String nome;

    @Column(precision = 10,scale = 2)
    private BigDecimal valor;

    @OneToMany(mappedBy = "convenio")
    private Set<Paciente> pacientes;

    public Convenio(){
    }

    public Convenio(String nome, BigDecimal valor) {
        this.nome = nome;
        this.valor = valor;
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

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public Set<Paciente> getPacientes() {
        return pacientes;
    }

    public void setPacientes(Set<Paciente> pacientes) {
        this.pacientes = pacientes;
    }
}
