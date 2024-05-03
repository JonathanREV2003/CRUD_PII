package com.example.CrudTest.services;


import com.example.CrudTest.entities.Agenda;
import java.util.List;

//paso 3
public interface AgendaServices {

    public List<Agenda> findAll();
    public Agenda findById(Long Id);

    //CRUD OPERATIONS
    public void create(Agenda agenda);
    public void update(Long id, Agenda agenda);
    public void delate(Long id);
}
