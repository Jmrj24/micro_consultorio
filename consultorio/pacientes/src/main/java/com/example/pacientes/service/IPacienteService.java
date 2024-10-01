package com.example.pacientes.service;

import com.example.pacientes.model.Paciente;

import java.util.List;

public interface IPacienteService {
    public List<Paciente> getAllPacientes();

    public void savePaciente(Paciente paci);

    public void deletePaciente(Long idPaciente);

    public Paciente getPaciente(Long idPaciente);

    public void editPaciente(Paciente paci);

    public Paciente getPacienteByDni(String dni);
}