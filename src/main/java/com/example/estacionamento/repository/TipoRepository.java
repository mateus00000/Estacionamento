package com.example.estacionamento.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.estacionamento.entities.Tipo;

public interface TipoRepository extends JpaRepository<Tipo, Long> {
    
}
