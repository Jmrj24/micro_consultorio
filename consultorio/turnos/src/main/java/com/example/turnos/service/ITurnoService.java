package com.example.turnos.service;

import com.example.turnos.model.Turno;

import java.time.LocalDate;
import java.util.List;

public interface ITurnoService {
    public void saveTurno(LocalDate fechaTurno, String tratamiento, String dni);

    public List<Turno> getAllTurnos();

    public void deleteTurno(Long idTurno);

    public Turno getTurnoById(Long idTurno);

    public void editTurno(Long idTurno, Turno turnRecibido);
}
