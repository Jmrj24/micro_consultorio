package com.example.turnos.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Turno {
    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE)
    private Long idTurno;
    @Temporal(TemporalType.DATE)
    private LocalDate fechaTurno;
    private String tratamiento;
    private String nombreCompletoPaci;
}
