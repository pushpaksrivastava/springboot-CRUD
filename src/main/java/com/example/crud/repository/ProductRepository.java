package com.example.crud.repository;

import com.example.crud.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.Id;

public interface ProductRepository extends JpaRepository<Product, Integer> {

    Product findByName(String name);
}
