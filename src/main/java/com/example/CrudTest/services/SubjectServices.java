package com.example.CrudTest.services;

import com.example.CrudTest.entities.Subject;

import java.util.List;

public interface SubjectServices {
    public List<Subject> findAll();
    public Subject findById(Long Id);

    public void create(Subject subject);
    public void update(Long id, Subject subject);
    public void  delate(Long id);
}
