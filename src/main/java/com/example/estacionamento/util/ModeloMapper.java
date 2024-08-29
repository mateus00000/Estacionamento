package com.example.estacionamento.util;

import com.example.estacionamento.dto.FabricanteDTO;
import com.example.estacionamento.dto.ModeloDTO;
import com.example.estacionamento.entities.Modelo;
import com.example.estacionamento.entities.Status;

public class ModeloMapper {
    public static ModeloDTO toDTO(Modelo modelo, Status status){

        FabricanteDTO fabricanteDTO = new FabricanteDTO();
        fabricanteDTO.setId(modelo.getFabricante().getId());
        fabricanteDTO.setNome(modelo.getFabricante().getNome());
        fabricanteDTO.setNacionalidade(modelo.getFabricante().getNacionalidade());

        return new ModeloDTO(modelo.getId(), modelo.getNome(), fabricanteDTO);
}     

    public static Modelo toEntity(ModeloDTO fabricanteDTO){
        Modelo modelo = new Modelo();
        modelo.setId(fabricanteDTO.getId());
        modelo.setNome(fabricanteDTO.getNome());
        modelo.setNacionalidade(fabricanteDTO.getNacionalidade());

        if (fabricanteDTO.getStatusDTO() != null){
            Status status = new Status();
            status.setId(fabricanteDTO.getStatusDTO().getId());
            status.setNome(fabricanteDTO.getStatusDTO().getNome());
            status.setCodigo(fabricanteDTO.getStatusDTO().getCodigo());
            modelo.setStatus(status);
        }

        return modelo;
    }
}
