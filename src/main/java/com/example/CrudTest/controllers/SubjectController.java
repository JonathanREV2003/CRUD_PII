package com.example.CrudTest.controllers;

import com.example.CrudTest.entities.Product;
import com.example.CrudTest.entities.Subject;
import com.example.CrudTest.services.SubjectServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/subject")
public class SubjectController {

    @Autowired
    SubjectServices subjectServices;

    @GetMapping
    public List<Subject> GetAll(){
        return subjectServices.findAll();
    }
    @GetMapping(value = "/{id}" )
    public Subject GetById(@PathVariable Long id){
        return subjectServices.findById(id);
    }

    @PostMapping
    public void create(@RequestBody Subject subject){

        subjectServices.create(subject);
    }
    @PutMapping(value="/{id}")
    public void update (@PathVariable Long id,
                        @RequestBody Subject subject){
        subjectServices.update(id, subject);
    }

    @DeleteMapping(value="/{id}")
    public void delete(@PathVariable Long id){

        subjectServices.delate(id);
    }
}
