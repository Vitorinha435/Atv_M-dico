package com.atividade.demo.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Consulta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Date dataHora;
    private String tipo; // Exemplo: "Retorno", "Primeira consulta"

    @ManyToOne
    private Medico medico;

    @ManyToOne
    private Paciente paciente;
}
