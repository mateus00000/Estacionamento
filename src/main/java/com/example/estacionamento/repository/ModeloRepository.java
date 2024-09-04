package com.example.estacionamento.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.estacionamento.entities.Modelo;

@Repository
public interface ModeloRepository extends JpaRepository <Modelo, Long> {

    /*@Query("SELECT m FROM Modelo m JOIN m.fabricante f WHERE f.nacionalidade = :nacionalidade")
    List<Modelo> findModelosByFabricanteNacionalidade(@Param("nacionalidade")String nacionalidade);*/

    //Usando uma query nativa para chamar a stored procedure com o paramentro nacionalidade
    @Query(value = "CALL GetModelosByNacionalidade(:nacionalidade)", nativeQuery = true)
    List<Modelo> findModelosByFabricanteNacionalidade(@Param("nacionalidade")String nacionalidade);
}
