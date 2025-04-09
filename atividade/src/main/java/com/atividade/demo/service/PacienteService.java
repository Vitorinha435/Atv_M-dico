package com.atividade.demo.service;

import com.atividade.demo.entity.Paciente;
import com.atividade.demo.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

    @Service
    public class PacienteService {

        @Autowired
        private PacienteRepository pacienteRepository;

        public List<Paciente> getAllPacientes() {
            return pacienteRepository.findAll();
        }

        public Optional<Paciente> getPacienteById(Long id) {
            return pacienteRepository.findById(id);
        }

        public Paciente savePaciente(Paciente paciente) {
            return pacienteRepository.save(paciente);
        }

        public void deletePaciente(Long id) {
            pacienteRepository.deleteById(id);
        }
        public Paciente updatePaciente(Long id, Paciente paciente) {
            Optional<Paciente> existingPacienteOpt = pacienteRepository.findById(id);

            if (existingPacienteOpt.isPresent()) {
                Paciente existingPaciente = existingPacienteOpt.get();
                existingPaciente.setNome(paciente.getNome());

                return pacienteRepository.save(existingPaciente);
            } else {

                throw new RuntimeException("Paciente não encontrado com o ID: " + id);
            }
        }
    }


