package com.facisa.banco_fase2.dtos.consulta;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record UpdateConsultaDto(BigDecimal valor, LocalDateTime dataHoraInicio, LocalDateTime dataHoraFim, Integer medicoId, Integer pacienteId) {
}
