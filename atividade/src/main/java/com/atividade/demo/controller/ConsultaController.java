package com.atividade.demo.controller;

import com.atividade.demo.entity.Consulta;
import com.atividade.demo.service.ConsultaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
    @RestController
    @RequestMapping("/consultas")
    public class ConsultaController {

        @Autowired
        private ConsultaService consultaService;

        @GetMapping
        public List<Consulta> getAllConsultas() {
            return consultaService.getAllConsultas();
        }
        @PutMapping("/{id}")
        public Consulta updateConsulta(@PathVariable Long id, @RequestBody Consulta consulta) {
            return consultaService.updateConsulta(id, consulta);
        }


        @PostMapping
        public Consulta saveConsulta(@RequestBody Consulta consulta) {
            return consultaService.saveConsulta(consulta);
        }

        @DeleteMapping("/{id}")
        public void deleteConsulta(@PathVariable Long id) {
            consultaService.deleteConsulta(id);
        }
    }

