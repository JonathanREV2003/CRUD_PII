package com.example.CrudTest.services;

import com.example.CrudTest.dao.SubjectDao;
import com.example.CrudTest.entities.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubjectServicesImpl implements SubjectServices{

    @Autowired
    SubjectDao subjectDao;

    @Override
    public List<Subject> findAll() {
        return (List<Subject>) subjectDao.findAll();
    }

    @Override
    public Subject findById(Long Id) {
        return subjectDao.findById(Id).orElse(null);
    }

    @Override
    public void create(Subject subject) {
        subjectDao.save(subject);
    }

    @Override
    public void update(Long id, Subject subject) {
        if (subjectDao.existsById(id)){
            subject.setId(id);
            subjectDao.save(subject);
        }
    }

    @Override
    public void delate(Long id) {
        if (subjectDao.existsById(id)) {
            subjectDao.deleteById(id);
        }
    }


}
