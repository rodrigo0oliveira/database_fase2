package com.facisa.banco_fase2.services;

import com.facisa.banco_fase2.domain.Consulta;
import com.facisa.banco_fase2.domain.Medico;
import com.facisa.banco_fase2.domain.Paciente;
import com.facisa.banco_fase2.dtos.consulta.ConsultaDto;
import com.facisa.banco_fase2.dtos.consulta.ResponseConsultaDto;
import com.facisa.banco_fase2.dtos.consulta.UpdateConsultaDto;
import com.facisa.banco_fase2.mappers.consulta.ConsultaMapper;
import com.facisa.banco_fase2.mappers.consulta.ConsultaRow;
import com.facisa.banco_fase2.repositories.consulta.ConsultaRepository;
import com.facisa.banco_fase2.repositories.medico.MedicoRepository;
import com.facisa.banco_fase2.repositories.paciente.PacienteRepository;
import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

@Service
public class ConsultaService {

    @Autowired
    private MedicoRepository medicoRepository;

    @Autowired
    private  PacienteRepository pacienteRepository;

    @Autowired
    private  ConsultaRepository consultaRepository;

    public ResponseConsultaDto createConsulta(ConsultaDto dto) {
        try{
            Medico medico = medicoRepository.findById(dto.medicoId()).orElseThrow(()-> new BadRequestException("Medico nao encontrado!"));
            Paciente paciente = pacienteRepository.findById(dto.pacienteId()).orElseThrow(()-> new BadRequestException("Paciente nao encontrado!"));

            Timestamp beginTimestamp = Timestamp.valueOf(dto.dataHoraInicio());
            Timestamp endTimestamp = Timestamp.valueOf(dto.dataHoraFim());

            boolean isAvailable = medicoRepository.callFunctionIsMedicoAvailable(medico.getId(),beginTimestamp,endTimestamp);

            if(!isAvailable){
                throw new BadRequestException("Medico nao disponivel no horario informado!");
            }

            Consulta consulta = ConsultaMapper.toDomain(new ConsultaRow(dto.valor(),beginTimestamp,endTimestamp,medico,paciente));

            Consulta created = consultaRepository.save(consulta);

            return ConsultaMapper.toResponse(created);
        }catch(BadRequestException e){
            throw new RuntimeException(e.getMessage());
        }catch(DataAccessException e){
            throw new RuntimeException(e.getRootCause().getMessage());
        }
    }

    public ResponseConsultaDto getById(Integer id) throws BadRequestException {
        Consulta consulta = consultaRepository.findById(id).orElseThrow(()-> new BadRequestException("Consulta nao encontrada"));

        return ConsultaMapper.toResponse(consulta);
    }

    public List<ResponseConsultaDto> findAll(){
        List<Consulta> consultas = consultaRepository.findAll();
        return consultas.stream().map(ConsultaMapper::toResponse).toList();
    }

    public ResponseConsultaDto updateById(Integer id, UpdateConsultaDto dto) throws BadRequestException {
        Consulta consulta = consultaRepository.findById(id).orElseThrow(()-> new BadRequestException("Consulta nao encontrada!"));

        Medico medico = medicoRepository.findById(dto.medicoId()).orElseThrow(()-> new BadRequestException("Medico nao encontrado!"));
        Paciente paciente = pacienteRepository.findById(dto.pacienteId()).orElseThrow(()-> new BadRequestException("Paciente nao encontrado!"));
        Optional.of(paciente).ifPresent(consulta::setPaciente);
        Optional.of(medico).ifPresent(consulta::setMedico);
        Optional.of(Timestamp.valueOf(dto.dataHoraInicio())).ifPresent(consulta::setData_hora_inicio);
        Optional.of(Timestamp.valueOf(dto.dataHoraFim())).ifPresent(consulta::setData_hora_fim);
        Optional.ofNullable(dto.valor()).ifPresent(consulta::setValor);

        Consulta updated = consultaRepository.save(consulta);

        return ConsultaMapper.toResponse(updated);
    }

    public void deleteById(Integer id){
        consultaRepository.deleteById(id);
    }

    public String finalizaConsulta(Integer id){
        try{
            consultaRepository.findById(id).orElseThrow(()-> new BadRequestException("Consulta nao encontrada!"));

            consultaRepository.callProcedureFinalizaConsulta(id);

            return "Consulta finalizada com sucesso";
        }catch(BadRequestException e){
            throw new RuntimeException(e.getMessage());
        }
        catch(DataAccessException e){
            throw new RuntimeException(e.getRootCause().getMessage());
        }
    }
}
