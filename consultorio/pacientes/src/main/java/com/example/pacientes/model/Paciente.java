package com.example.pacientes.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter @Setter
@Entity
public class Paciente {
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    private Long idPaciente;
    private String dni;
    private String nombre;
    private String apellido;
    @Temporal(TemporalType.DATE)
    private LocalDate fechaNacimiento;
    private String telefono;

    public Paciente() {
    }

    public Paciente(Long idPaciente, String dni, String nombre, String apellido, LocalDate fechaNacimiento, String telefono) {
        this.idPaciente = idPaciente;
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNacimiento = fechaNacimiento;
        this.telefono = telefono;
    }
}
