package com.example.CrudTest.services;

import com.example.CrudTest.dao.AgendaRepository;
import com.example.CrudTest.entities.Agenda;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

//Paso 4 <sistema inyeccion de dependencias>
@Service
public class AgendaServicesImpl implements AgendaServices {

    @Autowired
    AgendaRepository agendaRepository;

    @Override
    public List<Agenda> findAll() {
        return (List<Agenda>) agendaRepository.findAll();
    }

    @Override
    public Agenda findById(Long id) {
        return agendaRepository.findById(id).orElse(null);
    }

    @Override
    public void create(Agenda agenda) {
        agendaRepository.save(agenda);
    }

    @Override
    public void update(Long id, Agenda agenda) {
        if (agendaRepository.existsById(id)) {
            agenda.setId(id);
            agendaRepository.save(agenda);
        }
    }

    @Override
    public void delate(Long id) {
        if (agendaRepository.existsById(id)){
            agendaRepository.deleteById(id);
        }
    }
}
