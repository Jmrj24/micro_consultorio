package com.example.pacientes.controller;

import com.example.pacientes.model.Paciente;
import com.example.pacientes.service.IPacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {
    @Autowired
    private IPacienteService paciServi;

    @GetMapping("/traer")
    public List<Paciente> getAllPacientes() {
        return paciServi.getAllPacientes();
    }

    @PostMapping("/crear")
    public String savePaciente(@RequestBody Paciente paci) {
        paciServi.savePaciente(paci);
        return "Paciente creado correctamente!";
    }

    @DeleteMapping("/borrar/{idPaciente}")
    public String deletePaciente(@PathVariable Long idPaciente) {
        paciServi.deletePaciente(idPaciente);
        return "Paciente eliminado correctamente!";
    }

    @PutMapping("/editar")
    public Paciente editPaciente(@RequestBody Paciente paci) {
        paciServi.editPaciente(paci);
        return paciServi.getPaciente(paci.getIdPaciente());
    }

    @GetMapping("/{idPaciente}")
    public Paciente getPaciente(@PathVariable Long idPaciente) {
        return paciServi.getPaciente(idPaciente);
    }

    @GetMapping("/traerdni/{dniPaciente}")
    public Paciente getPacienteByDni(@PathVariable String dniPaciente) {
        return paciServi.getPacienteByDni(dniPaciente);
    }

}
