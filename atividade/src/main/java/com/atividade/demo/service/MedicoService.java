package com.atividade.demo.service;

import com.atividade.demo.entity.Medico;
import com.atividade.demo.repository.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

    @Service
    public class MedicoService {

        @Autowired
        private MedicoRepository medicoRepository;

        public List<Medico> getAllMedicos() {
            return medicoRepository.findAll();
        }

        public Optional<Medico> getMedicoById(Long id) {
            return medicoRepository.findById(id);
        }

        public Medico saveMedico(Medico medico) {
            return medicoRepository.save(medico);
        }

        public void deleteMedico(Long id) {
            medicoRepository.deleteById(id);
        }
        public Medico updateMedico(Long id, Medico medico) {
            Optional<Medico> existingMedicoOpt = medicoRepository.findById(id);

            if (existingMedicoOpt.isPresent()) {
                Medico existingMedico = existingMedicoOpt.get();
                existingMedico.setNome(medico.getNome());
                return medicoRepository.save(existingMedico);
            } else {
                throw new RuntimeException("Médico não encontrado com o ID: " + id);
            }
        }
    }


