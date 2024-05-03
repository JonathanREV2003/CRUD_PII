package com.example.CrudTest.controllers;

import com.example.CrudTest.entities.Product;
import com.example.CrudTest.services.ProductServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//paso 5 <controlador>
@RestController
@RequestMapping("/student")
public class ProductController {

    @Autowired
    ProductServices productServices;

    @GetMapping
    public List<Product> GetAll(){
        return productServices.findAll();
    }
    //OBTENER por ID
    @GetMapping(value="/{id}")
    public Product GetById(@PathVariable Long id){
        return productServices.findById(id);
    }


    //CRUD controller
    @PostMapping
    public void create(@RequestBody Product product){

        productServices.create(product);
    }
    //editar   <localhost:8080/products/5>
    @PutMapping(value="/{id}")
    public void update (@PathVariable Long id,
                        @RequestBody Product product){
        productServices.update(id, product);
    }

    //localhost:8080/products/5
    @DeleteMapping(value="/{id}")
    public void delete(@PathVariable Long id){

        productServices.delate(id);
    }
}