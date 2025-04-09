package com.atividade.demo.service;

import com.atividade.demo.entity.Consulta;
import com.atividade.demo.repository.ConsultaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

    @Service
    public class ConsultaService {

        @Autowired
        private ConsultaRepository consultaRepository;

        public List<Consulta> getAllConsultas() {
            return consultaRepository.findAll();
        }

        public Optional<Consulta> getConsultaById(Long id) {
            return consultaRepository.findById(id);
        }

        public Consulta saveConsulta(Consulta consulta) {
            return consultaRepository.save(consulta);
        }

        public void deleteConsulta(Long id) {
            consultaRepository.deleteById(id);
        }
        public Consulta updateConsulta(Long id, Consulta consulta) {
            Optional<Consulta> existingConsulta = consultaRepository.findById(id);

            if (existingConsulta.isPresent()) {
                Consulta consultaToUpdate = existingConsulta.get();

                consultaToUpdate.setDataHora(consulta.getDataHora());
                consultaToUpdate.setTipo(consulta.getTipo());
                consultaToUpdate.setMedico(consulta.getMedico());
                consultaToUpdate.setPaciente(consulta.getPaciente());

                return consultaRepository.save(consultaToUpdate);
            }

            return null;
        }
    }

