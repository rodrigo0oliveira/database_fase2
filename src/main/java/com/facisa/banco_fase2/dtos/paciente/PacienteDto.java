package com.facisa.banco_fase2.dtos.paciente;

import com.facisa.banco_fase2.domain.Endereco;
import com.facisa.banco_fase2.dtos.endereco.EnderecoDto;

import java.util.Date;

public record PacienteDto(String nome, String cpf, String telefone, Date dataNascimento, String email, EnderecoDto endereco) {
}
