package com.example.turnos.repository;

import com.example.turnos.model.Paciente;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "apiConsumirPaciente", url = "http://localhost:9001")
public interface IPacienteAPIClient {
    @GetMapping("/pacientes/traerdni/{dni}")
    public Paciente getPacientedni(@PathVariable String dni);
}
