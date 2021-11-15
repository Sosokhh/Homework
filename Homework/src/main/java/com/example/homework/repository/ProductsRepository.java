package com.example.homework.repository;

import com.example.homework.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductsRepository extends JpaRepository<Product, String> {
     //List<Products> findByProduct_Name(String Product_Name);


    }
