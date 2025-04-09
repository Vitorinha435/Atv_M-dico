package com.atividade.demo.controller;

import com.atividade.demo.entity.Paciente;
import com.atividade.demo.service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

    @RestController
    @RequestMapping("/pacientes")
    public class PacienteController {

        @Autowired
        private PacienteService pacienteService;

        @GetMapping
        public List<Paciente> getAllPacientes() {
            return pacienteService.getAllPacientes();
        }
        @PutMapping("/{id}")
        public Paciente updatePaciente(@PathVariable Long id, @RequestBody Paciente paciente) {
            return pacienteService.updatePaciente(id, paciente);
        }

        @PostMapping
        public Paciente savePaciente(@RequestBody Paciente paciente) {
            return pacienteService.savePaciente(paciente);
        }

        @DeleteMapping("/{id}")
        public void deletePaciente(@PathVariable Long id) {
            pacienteService.deletePaciente(id);
        }
    }

