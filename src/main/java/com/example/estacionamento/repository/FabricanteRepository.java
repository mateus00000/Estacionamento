package com.example.estacionamento.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.estacionamento.entities.Fabricante;

@Repository
public interface FabricanteRepository extends JpaRepository<Fabricante, Long>{

    List<Fabricante> findByNacionalidade(String nacionalidade);

    // Método para contar fabricantes pela nacionalidade
    long countByNacionalidade(String nacionalidade);
}
