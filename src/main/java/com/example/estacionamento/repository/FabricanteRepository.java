package com.example.estacionamento.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.estacionamento.entities.Fabricante;

public interface FabricanteRepository extends JpaRepository<Fabricante, Long>{
    
}
