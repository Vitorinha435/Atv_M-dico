package com.atividade.demo.controller;

import com.atividade.demo.entity.Medico;
import com.atividade.demo.service.MedicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

    @RestController
    @RequestMapping("/medicos")
    public class MedicoController {

        @Autowired
        private MedicoService medicoService;

        @GetMapping
        public List<Medico> getAllMedicos() {
            return medicoService.getAllMedicos();
        }

        @PutMapping("/{id}")
        public Medico updateMedico(@PathVariable Long id, @RequestBody Medico medico) {
            return medicoService.updateMedico(id, medico);
        }

        @PostMapping
        public Medico saveMedico(@RequestBody Medico medico) {
            return medicoService.saveMedico(medico);
        }

        @DeleteMapping("/{id}")
        public void deleteMedico(@PathVariable Long id) {
            medicoService.deleteMedico(id);
        }
    }

