package com.facisa.banco_fase2.repositories.consulta;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

@Repository
public class CustomConsultaRepository {

    @PersistenceContext
    private EntityManager em;

    public void callProcedureFinalizaConsulta(Integer id){
        em.createNativeQuery("CALL prc_finaliza_consulta(:id)")
                .setParameter("id", id)
                .executeUpdate();
    }
}