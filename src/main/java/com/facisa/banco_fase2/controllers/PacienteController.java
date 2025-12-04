package com.facisa.banco_fase2.controllers;

import com.facisa.banco_fase2.domain.Paciente;
import com.facisa.banco_fase2.dtos.paciente.PacienteDto;
import com.facisa.banco_fase2.dtos.paciente.UpdatePacienteDto;
import com.facisa.banco_fase2.services.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/paciente")
public class PacienteController {

    @Autowired
    private PacienteService pacienteService;

    @PostMapping
    public ResponseEntity<?> createPaciente(@RequestBody PacienteDto dto) {
        try {
            Paciente paciente = pacienteService.createPaciente(dto);
            return ResponseEntity.ok(paciente);
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body("Erro ao criar paciente: " + ex.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity<?> getAllPacientes() {
        try {
            List<Paciente> pacientes = pacienteService.getAllPacientes();
            return ResponseEntity.ok(pacientes);
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body("Erro ao buscar pacientes: " + ex.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getPacienteById(@PathVariable Integer id) {
        try {
            Paciente paciente = pacienteService.getPacienteById(id);
            return ResponseEntity.ok(paciente);
        } catch (Exception ex) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePaciente(@PathVariable Integer id) {
        try {
            pacienteService.deletePacienteById(id);
            return ResponseEntity.ok("Paciente deletado com sucesso!");
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body("Erro ao deletar paciente: " + ex.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updatePaciente(@PathVariable Integer id, @RequestBody UpdatePacienteDto dto) {
        try {
            Paciente paciente = pacienteService.updatePaciente(id,dto);
            return ResponseEntity.ok(paciente);
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body("Erro ao atualizar paciente: " + ex.getMessage());
        }
    }
}
