package com.atividade.demo.repository;

import com.atividade.demo.entity.Consulta;
import org.springframework.data.jpa.repository.JpaRepository;

    public interface ConsultaRepository extends JpaRepository<Consulta, Long> {
    }


