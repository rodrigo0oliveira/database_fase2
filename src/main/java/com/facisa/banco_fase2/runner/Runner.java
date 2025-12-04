package com.facisa.banco_fase2.runner;

import com.facisa.banco_fase2.domain.*;
import com.facisa.banco_fase2.repositories.consulta.ConsultaRepository;
import com.facisa.banco_fase2.repositories.medico.MedicoRepository;
import com.facisa.banco_fase2.repositories.paciente.PacienteRepository;
import com.facisa.banco_fase2.repositories.pagamento_consulta.PagamentoConsultaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@Component
public class Runner implements CommandLineRunner {

    @Autowired
    private MedicoRepository medicoRepository;

    @Autowired
    private PacienteRepository pacienteRepository;

    @Autowired
    private ConsultaRepository consultaRepository;

    @Autowired
    private PagamentoConsultaRepository pagamentoConsultaRepository;

    @Override
    public void run(String... args) throws Exception {
        cleanData();

        Set<Especialidade> especialidades = especialidades();

        Endereco e1 = new Endereco("Rua das Flores", "Bairro Jardim", "Recife", "PE");
        Endereco e2 = new Endereco("Rua do Sol", "Bairro Centro", "João Pessoa", "PB");
        Endereco e3 = new Endereco("Avenida Brasil", "Bairro São José", "Campina Grande", "PB");
        Endereco e4 = new Endereco("Rua da Paz", "Bairro Boa Vista", "Olinda", "PE");

        Medico m1 = new Medico("Joao","123456789", e1, especialidades);
        Medico m2 = new Medico("Mario","987654321", e2, especialidades);

        Paciente p1 = new Paciente(
                "Ana Silva",
                "12345678901",
                java.sql.Date.valueOf("1990-05-10"),
                "81999999999",
                "ana.silva@email.com",
                e3
        );

        Paciente p2 = new Paciente(
                "Carlos Souza",
                "98765432100",
                java.sql.Date.valueOf("1985-08-22"),
                "81988888888",
                "carlos.souza@email.com",
                e4
        );

        medicoRepository.saveAll(Arrays.asList(m1, m2));
        pacienteRepository.saveAll(Arrays.asList(p1, p2));

    }

    private Set<Especialidade> especialidades(){
        Set<Especialidade> especialidades = new HashSet<>();
        Especialidade especialidade1 = new Especialidade("Cardiologista");
        Especialidade especialidade2 = new Especialidade("Geral");

        especialidades.add(especialidade1);
        especialidades.add(especialidade2);


        return especialidades;
    }

    private void cleanData(){
        pagamentoConsultaRepository.deleteAll();
        consultaRepository.deleteAll();
        medicoRepository.deleteAll();
        pacienteRepository.deleteAll();
    }
}
