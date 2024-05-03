package com.example.CrudTest.entities;


import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

//Paso 1
@Entity
@Table(name = "product")
@Getter
@Setter
public class Agenda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//autoincremental
    private Long id;

    @NotBlank(message = "No puede estar vacio")
    @NotEmpty(message = "No puede estar vacio")
    private String name;

    @Column(name ="created_at")
    @Temporal(TemporalType.DATE) //espesificar que es tipo fecha
    private Date createdAt;

}
