package com.example.estacionamento.util;

import com.example.estacionamento.dto.FabricanteDTO;
import com.example.estacionamento.entities.Fabricante;

public class FabricanteMapper {
    public static FabricanteDTO toDTO(Fabricante fabricante){
        return new FabricanteDTO(fabricante.getId(), fabricante.getNome(), fabricante.getNacionalidade());
}     

    public static Fabricante toEntity(FabricanteDTO fabricanteDTO){
        Fabricante fabricante = new Fabricante();
        fabricante.setId(fabricanteDTO.getId());
        fabricante.setNome(fabricanteDTO.getNome());
        fabricante.setNacionalidade(fabricanteDTO.getNacionalidade());

        return fabricante;
    }
}
