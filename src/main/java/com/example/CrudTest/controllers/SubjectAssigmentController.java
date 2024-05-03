package com.example.CrudTest.controllers;

import com.example.CrudTest.entities.Product;
import com.example.CrudTest.entities.SubjectAssignment;
import com.example.CrudTest.services.SubjectAssigmenServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/subject_assigment")
public class SubjectAssigmentController {

    @Autowired
    SubjectAssigmenServices subjectAssigmenServices;

    @GetMapping
    public List<SubjectAssignment> GetAll(){
        return subjectAssigmenServices.findAll();
    }
    @GetMapping(value="/{id}")
    public SubjectAssignment GetById(@PathVariable Long id){
        return subjectAssigmenServices.findById(id);
    }

    //CRUD controller
    @PostMapping
    public void create(@RequestBody SubjectAssignment subjectAssignment){

        subjectAssigmenServices.create(subjectAssignment);
    }

    @PutMapping(value="/{id}")
    public void update (@PathVariable Long id,
                        @RequestBody SubjectAssignment subjectAssignment){
        subjectAssigmenServices.update(id, subjectAssignment);
    }

    @DeleteMapping(value="/{id}")
    public void delete(@PathVariable Long id){

        subjectAssigmenServices.delate(id);
    }
}
