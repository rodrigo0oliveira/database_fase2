package com.facisa.banco_fase2.services;

import com.facisa.banco_fase2.domain.Paciente;
import com.facisa.banco_fase2.dtos.paciente.PacienteDto;
import com.facisa.banco_fase2.dtos.paciente.UpdatePacienteDto;
import com.facisa.banco_fase2.mappers.paciente.PacienteMapper;
import com.facisa.banco_fase2.repositories.paciente.PacienteRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PacienteService {

    @Autowired
    private PacienteRepository pacienteRepository;

    public Paciente createPaciente(PacienteDto paciente) {
        Paciente toPaciente = PacienteMapper.toResponse(paciente);
        return pacienteRepository.save(toPaciente);
    }

    public List<Paciente> getAllPacientes() {
        return pacienteRepository.findAll();
    }

    public Paciente getPacienteById(Integer id) {
        return pacienteRepository.findById(id).orElseThrow(()-> new EntityNotFoundException("Paciente nao encontrado!"));
    }

    public void deletePacienteById(Integer id) {
        pacienteRepository.deleteById(id);
    }

    public Paciente updatePaciente(Integer id,UpdatePacienteDto updatePacienteDto) {
        Paciente paciente = pacienteRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Paciente não encontrado!"));

        if (updatePacienteDto.nome() != null) {
            paciente.setNome(updatePacienteDto.nome());
        }

        if (updatePacienteDto.telefone() != null) {
            paciente.setTelefone(updatePacienteDto.telefone());
        }

        if(updatePacienteDto.dataNascimento() != null) {
            paciente.setData_nascimento(updatePacienteDto.dataNascimento());
        }

        return pacienteRepository.save(paciente);
    }

}
