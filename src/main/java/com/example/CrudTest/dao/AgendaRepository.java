package com.example.CrudTest.dao;

//paso 2 <"Consistencia" interactuar con la entidad product>
//CrudRepository >> 4 operaciones basicas:  Update, Delate, New, crated

import com.example.CrudTest.entities.Agenda;
import org.springframework.data.repository.CrudRepository;

//                                                           v tipo de Id q identifica Product
public interface AgendaRepository extends CrudRepository<Agenda, Long> {
}
