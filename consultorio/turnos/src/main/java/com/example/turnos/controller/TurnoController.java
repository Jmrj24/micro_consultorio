package com.example.turnos.controller;

import com.example.turnos.dto.TurnoDTO;
import com.example.turnos.model.Turno;
import com.example.turnos.service.ITurnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/turnos")
public class TurnoController {
    @Autowired
    private ITurnoService turnoServi;

    @GetMapping("/traer")
    public List<Turno> getAllTurnos() {
        return turnoServi.getAllTurnos();
    }

    @PostMapping("/crear")
    public String saveTurno(@RequestBody TurnoDTO turno) {
        turnoServi.saveTurno(turno.getFecha(), turno.getTratamiento(), turno.getDni());
        return "Se ha agregado el turno correctamente";
    }

    @DeleteMapping("/borrar/{idTurno}")
    public String deleteTurno(@PathVariable Long idTurno) {
        turnoServi.deleteTurno(idTurno);
        return "Se ha eliminado el turno correctamente";
    }

    @PutMapping("/editar/{idTurno}")
    public Turno editTurno(@PathVariable Long idTurno,
                           @RequestBody Turno turnRecibido) {
        turnoServi.editTurno(idTurno, turnRecibido);
        return turnoServi.getTurnoById(idTurno);
    }

}
