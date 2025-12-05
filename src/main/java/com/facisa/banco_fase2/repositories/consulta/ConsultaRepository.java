package com.facisa.banco_fase2.repositories.consulta;

import com.facisa.banco_fase2.domain.Consulta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConsultaRepository extends JpaRepository<Consulta,Integer> {
}
