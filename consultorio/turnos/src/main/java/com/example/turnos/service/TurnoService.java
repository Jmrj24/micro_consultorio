package com.example.turnos.service;

import com.example.turnos.model.Paciente;
import com.example.turnos.model.Turno;
import com.example.turnos.repository.IPacienteAPIClient;
import com.example.turnos.repository.ITurnoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.util.List;

@Service
public class TurnoService implements ITurnoService {
    @Autowired
    private ITurnoRepository turnoRepo;

    @Autowired
    private IPacienteAPIClient ipacienteAPIClient;

    @Override
    public void saveTurno(LocalDate fechaTurno, String tratamiento, String dni) {

        Paciente paci = ipacienteAPIClient.getPacientedni(dni);

        Turno turn = new Turno();
        turn.setFechaTurno(fechaTurno);
        turn.setTratamiento(tratamiento);
        turn.setNombreCompletoPaci(paci.getNombre()+" "+paci.getApellido());

        turnoRepo.save(turn);
    }

    @Override
    public List<Turno> getAllTurnos() {
        return turnoRepo.findAll();
    }

    @Override
    public void deleteTurno(Long idTurno) {
        turnoRepo.deleteById(idTurno);
    }

    @Override
    public Turno getTurnoById(Long idTurno) {
        return turnoRepo.findById(idTurno).orElse(null);
    }

    @Override
    public void editTurno(Long idTurno, Turno turnRecibido) {
        Turno turnEditar = this.getTurnoById(idTurno);

        turnEditar.setFechaTurno(turnRecibido.getFechaTurno());
        turnEditar.setTratamiento(turnRecibido.getTratamiento());
        turnEditar.setNombreCompletoPaci(turnRecibido.getNombreCompletoPaci());
        turnoRepo.save(turnEditar);
    }
}
