package com.example.CrudTest.services;

import com.example.CrudTest.entities.Product;
import com.example.CrudTest.entities.SubjectAssignment;

import java.util.List;

public interface SubjectAssigmenServices {

    public List<SubjectAssignment>findAll();
    public SubjectAssignment findById(Long Id);

    public void create(SubjectAssignment subjectAssignment);
    public void update(Long id,SubjectAssignment subjectAssignment);
    public void delate(Long id);

}
