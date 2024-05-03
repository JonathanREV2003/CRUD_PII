package com.example.CrudTest.dao;

import com.example.CrudTest.entities.SubjectAssignment;
import org.springframework.data.repository.CrudRepository;

public interface SubjectAssigmenDao extends CrudRepository<SubjectAssignment, Long> {
}
