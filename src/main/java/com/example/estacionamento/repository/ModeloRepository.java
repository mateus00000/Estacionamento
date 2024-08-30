package com.example.estacionamento.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.estacionamento.entities.Modelo;

public interface ModeloRepository extends JpaRepository <Modelo, Long> {
    
}
