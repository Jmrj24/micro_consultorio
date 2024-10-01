package com.example.pacientes.service;

import com.example.pacientes.model.Paciente;
import com.example.pacientes.repository.IPacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PacienteService implements IPacienteService {
    @Autowired
    IPacienteRepository paciRepo;

    @Override
    public List<Paciente> getAllPacientes() {
        return paciRepo.findAll();
    }

    @Override
    public void savePaciente(Paciente paci) {
        paciRepo.save(paci);
    }

    @Override
    public void deletePaciente(Long idPaciente) {
        paciRepo.deleteById(idPaciente);
    }

    @Override
    public Paciente getPaciente(Long idPaciente) {
        return paciRepo.findById(idPaciente).orElse(null);
    }

    @Override
    public void editPaciente(Paciente paci) {
        this.savePaciente(paci);
    }

    @Override
    public Paciente getPacienteByDni(String dni) {
        //Forma de retornar paciente con los metodos por defecto del JPA
        /*List<Paciente> listaPacientes = this.getAllPacientes();
        Paciente paciDni = null;

        for(Paciente paci : listaPacientes) {
            if(paci.getDni().equals(dni)) {
                paciDni = paci;
            }
        }*/
        return paciRepo.findPacienteByDni(dni);
    }
}
