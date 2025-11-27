package com.facisa.banco_fase2.dtos.consulta;

import java.math.BigDecimal;
import java.sql.Timestamp;

public record ResponseConsultaDto (Integer id, Boolean realizado, BigDecimal valor, Timestamp dataHoraInicio,Timestamp dataHoraFim,String medicoNome,String pacienteNome){}
