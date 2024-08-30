package com.example.estacionamento.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.estacionamento.entities.Veiculo;

public interface VeiculoRepository extends JpaRepository <Veiculo, Long> {
    
}
