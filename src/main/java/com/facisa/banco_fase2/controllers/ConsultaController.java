package com.facisa.banco_fase2.controllers;

import com.facisa.banco_fase2.dtos.consulta.ConsultaDto;
import com.facisa.banco_fase2.dtos.consulta.ResponseConsultaDto;
import com.facisa.banco_fase2.dtos.consulta.UpdateConsultaDto;
import com.facisa.banco_fase2.services.ConsultaService;
import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/consulta")
public class ConsultaController {

    @Autowired
    private  ConsultaService consultaService;

    @PostMapping
    public ResponseEntity<?> createConsulta(@RequestBody ConsultaDto dto){
        try {
            ResponseConsultaDto consulta = consultaService.createConsulta(dto);

            return ResponseEntity.status(201).body(consulta);
        } catch (BadRequestException e) {
            return ResponseEntity.status(400).body(e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Integer id){
        try {
            ResponseConsultaDto consulta = consultaService.getById(id);

            return ResponseEntity.ok(consulta);
        }catch (BadRequestException e){
            return ResponseEntity.status(400).body(e.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity<?> findAll(){
         List<ResponseConsultaDto> consultaDtoList = consultaService.findAll();

         return ResponseEntity.ok(consultaDtoList);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateById(@PathVariable Integer id, @RequestBody UpdateConsultaDto dto){
        try {
            ResponseConsultaDto updated = consultaService.updateById(id, dto);
            return ResponseEntity.ok(updated);
        } catch (BadRequestException e){
            return ResponseEntity.status(400).body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Integer id){
        try {
            consultaService.deleteById(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e){
            return ResponseEntity.status(400).body("Erro ao deletar consulta: " + e.getMessage());
        }
    }
}
