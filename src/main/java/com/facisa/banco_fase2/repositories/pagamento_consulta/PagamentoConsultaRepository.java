package com.facisa.banco_fase2.repositories.pagamento_consulta;

import com.facisa.banco_fase2.domain.PagamentoConsulta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PagamentoConsultaRepository extends JpaRepository<PagamentoConsulta, Integer> {

    void deleteByConsultaId(Integer medicoId);
}
