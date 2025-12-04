package com.facisa.banco_fase2.dtos.paciente;

import java.util.Date;

public record UpdatePacienteDto(String nome, String telefone, Date dataNascimento) {
}
