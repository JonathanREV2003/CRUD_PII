package com.example.CrudTest.entities;


import jakarta.persistence.*;

import java.util.Date;

//Paso 1
@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//autoincremental
    private Long id;
    private String name;
    private String email;
    private Integer anos;

    @Column(name ="created_at")
    @Temporal(TemporalType.DATE) //espesificar q es tipo fecha
    private Date createdAt;

    //Getters and setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAnos() {
        return anos;
    }

    public void setAnos(Integer anos) {
        this.anos = anos;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
