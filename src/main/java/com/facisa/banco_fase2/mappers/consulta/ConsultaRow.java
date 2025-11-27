package com.facisa.banco_fase2.mappers.consulta;

import com.facisa.banco_fase2.domain.Medico;
import com.facisa.banco_fase2.domain.Paciente;

import java.math.BigDecimal;
import java.sql.Timestamp;

public record ConsultaRow (BigDecimal valor, Timestamp dataHoraInicio, Timestamp dataHoraFim, Medico medico, Paciente paciente){}