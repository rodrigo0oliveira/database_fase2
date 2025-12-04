package com.facisa.banco_fase2.mappers.paciente;

import com.facisa.banco_fase2.domain.Endereco;
import com.facisa.banco_fase2.domain.Paciente;
import com.facisa.banco_fase2.dtos.paciente.PacienteDto;

public class PacienteMapper {

    public static Paciente toResponse(PacienteDto paciente){
        Endereco endereco = new Endereco(paciente.endereco().rua(),paciente.endereco().cidade(),paciente.endereco().estado(),paciente.endereco().estado());

        return new Paciente(paciente.nome(),paciente.cpf(),paciente.dataNascimento(),paciente.telefone(),paciente.email(),endereco);
    }
}
