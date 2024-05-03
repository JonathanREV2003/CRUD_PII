package com.example.CrudTest.controllers;

import com.example.CrudTest.entities.Agenda;
import com.example.CrudTest.services.AgendaServices;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

//paso 5 <controlador>
@RestController
@RequestMapping("/agenda")
public class AgendaController {

    @Autowired
    AgendaServices agendaServices;

    @GetMapping
    public List<Agenda> GetAll(){
        return agendaServices.findAll();
    }
    //OBTENER por ID
    @GetMapping(value="/{id}")
    public Agenda GetById(@PathVariable Long id){
        return agendaServices.findById(id);
    }


    //CRUD controller
    @PostMapping
    public void create(@Valid @RequestBody Agenda agenda){

        agendaServices.create(agenda);
    }
    //editar   <localhost:8080/product/5>
    @PutMapping(value="/{id}")
    public void update (@PathVariable Long id,
                        @RequestBody Agenda agenda){
        agendaServices.update(id, agenda);
    }

    //localhost:8080/product/5
    @DeleteMapping(value="/{id}")
    public void delete(@PathVariable Long id){

        agendaServices.delate(id);
    }

    //manejo de errores (solo este controlador)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExeption(
            MethodArgumentNotValidException ex
    ){
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }
}