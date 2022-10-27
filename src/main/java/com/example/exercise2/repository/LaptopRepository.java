package com.example.exercise2.repository;

import  com.example.exercise2.entities.Laptop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface LaptopRepository extends JpaRepository<Laptop,Long> {}
