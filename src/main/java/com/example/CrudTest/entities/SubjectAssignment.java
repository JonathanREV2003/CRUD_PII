package com.example.CrudTest.entities;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "subjectassignment")
public class SubjectAssignment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer subjectid;
    private Integer studentid;

    @Column(name ="created_at")
    @Temporal(TemporalType.DATE)
    private Date createdAt;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getSubjectId() {
        return subjectid;
    }

    public void setSubjectId(Integer subjectId) {
        this.subjectid = subjectId;
    }

    public Integer getStudentId() {
        return studentid;
    }

    public void setStudentId(Integer studentId) {
        this.studentid = studentId;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
}
