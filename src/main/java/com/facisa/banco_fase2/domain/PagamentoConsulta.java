package com.facisa.banco_fase2.domain;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.sql.Timestamp;

@Entity
@Table(name = "pagamento_consulta")
public class PagamentoConsulta {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(precision = 10,scale = 2)
    private BigDecimal valor;

    private Timestamp data_hora;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "consulta_id",nullable = false,unique = true)
    private Consulta consulta;

}
