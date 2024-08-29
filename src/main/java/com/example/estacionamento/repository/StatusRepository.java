package com.example.estacionamento.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.estacionamento.entities.Status;

public interface StatusRepository extends JpaRepository <Status, Long>{
    
}
