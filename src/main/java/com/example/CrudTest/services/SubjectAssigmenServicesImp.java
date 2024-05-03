package com.example.CrudTest.services;

import com.example.CrudTest.dao.SubjectAssigmenDao;
import com.example.CrudTest.entities.SubjectAssignment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubjectAssigmenServicesImp implements SubjectAssigmenServices {

    @Autowired
    SubjectAssigmenDao subjectAssigmenDao;

    @Override
    public List<SubjectAssignment> findAll() {
        return (List<SubjectAssignment>) subjectAssigmenDao.findAll();
    }

    @Override
    public SubjectAssignment findById(Long Id) {
        return subjectAssigmenDao.findById(Id).orElse(null);
    }

    @Override
    public void create(SubjectAssignment subjectAssignment) {
        subjectAssigmenDao.save(subjectAssignment);
    }

    @Override
    public void update(Long id, SubjectAssignment subjectAssignment) {
        if (subjectAssigmenDao.existsById(id)){
            subjectAssignment.setId(id);
            subjectAssigmenDao.save(subjectAssignment);
        }
    }

    @Override
    public void delate(Long id) {
        if(subjectAssigmenDao.existsById(id)){
            subjectAssigmenDao.deleteById(id);
        }
    }
}
