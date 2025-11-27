package com.facisa.banco_fase2.domain;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.sql.Timestamp;

@Entity
@Table(name = "consulta")
public class Consulta {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(precision = 10,scale = 2)
    private BigDecimal valor;

    private Timestamp data_hora_inicio;

    private Timestamp data_hora_fim;

    private Boolean realizado;

    @ManyToOne
    @JoinColumn(name = "medico_id")
    private Medico medico;

    @ManyToOne
    @JoinColumn(name = "paciente_id")
    private Paciente paciente;

    @OneToOne(mappedBy = "consulta")
    private PagamentoConsulta pagamentoConsulta;

    public Consulta(BigDecimal valor, Timestamp data_hora_fim, Timestamp data_hora_inicio, Boolean realizado, Medico medico, Paciente paciente) {
        this.valor = valor;
        this.data_hora_fim = data_hora_fim;
        this.data_hora_inicio = data_hora_inicio;
        this.realizado = realizado;
        this.medico = medico;
        this.paciente = paciente;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public Timestamp getData_hora_inicio() {
        return data_hora_inicio;
    }

    public void setData_hora_inicio(Timestamp data_hora_inicio) {
        this.data_hora_inicio = data_hora_inicio;
    }

    public Timestamp getData_hora_fim() {
        return data_hora_fim;
    }

    public void setData_hora_fim(Timestamp data_hora_fim) {
        this.data_hora_fim = data_hora_fim;
    }

    public Boolean getRealizado() {
        return realizado;
    }

    public void setRealizado(Boolean realizado) {
        this.realizado = realizado;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }
}
