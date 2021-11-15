package com.example.homework.repository;

import com.example.homework.model.Sale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SalesRepository extends JpaRepository <Sale, Integer>{
}
