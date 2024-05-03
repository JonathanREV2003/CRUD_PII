package com.example.CrudTest.services;


import com.example.CrudTest.entities.Product;
import java.util.List;

//paso 3
public interface ProductServices {

    public List<Product> findAll();
    public Product findById(Long Id);

    //CRUD OPERATIONS
    public void create(Product product);
    public void update(Long id,Product product);
    public void delate(Long id);
}
