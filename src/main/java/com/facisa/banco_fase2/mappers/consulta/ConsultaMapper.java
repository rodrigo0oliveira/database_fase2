package com.facisa.banco_fase2.mappers.consulta;

import com.facisa.banco_fase2.domain.Consulta;
import com.facisa.banco_fase2.dtos.consulta.ResponseConsultaDto;

public class ConsultaMapper {

    public static Consulta toDomain(ConsultaRow row){
        return new Consulta(row.valor(),row.dataHoraInicio(),row.dataHoraFim(),false,row.medico(),row.paciente());
    }

    public static ResponseConsultaDto toResponse(Consulta consulta){
        return new ResponseConsultaDto(consulta.getId(),consulta.getRealizado(),consulta.getValor(),consulta.getData_hora_inicio(),consulta.getData_hora_fim(), consulta.getMedico().getNome(), consulta.getPaciente().getNome());
    }
}
