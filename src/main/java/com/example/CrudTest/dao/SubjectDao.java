package com.example.CrudTest.dao;

import com.example.CrudTest.entities.Subject;
import org.springframework.data.repository.CrudRepository;

public interface SubjectDao extends CrudRepository <Subject, Long> {
}
