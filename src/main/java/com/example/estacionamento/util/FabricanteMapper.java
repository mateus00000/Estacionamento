package com.example.estacionamento.util;

import com.example.estacionamento.dto.FabricanteDTO;
import com.example.estacionamento.dto.StatusDTO;
import com.example.estacionamento.entities.Fabricante;
import com.example.estacionamento.entities.Status;

public class FabricanteMapper {
    public static FabricanteDTO toDTO(Fabricante fabricante){

        StatusDTO statusDTO = new StatusDTO();
        statusDTO.setId(fabricante.getStatus().getId());
        statusDTO.setNome(fabricante.getStatus().getNome());
        statusDTO.setCodigo(fabricante.getStatus().getCodigo());

        return new FabricanteDTO(fabricante.getId(), fabricante.getNome(), fabricante.getNacionalidade(), statusDTO);
}     

    public static Fabricante toEntity(FabricanteDTO fabricanteDTO){
        Fabricante fabricante = new Fabricante();
        fabricante.setId(fabricanteDTO.getId());
        fabricante.setNome(fabricanteDTO.getNome());
        fabricante.setNacionalidade(fabricanteDTO.getNacionalidade());

        if (fabricanteDTO.getStatusDTO() != null){
            Status status = new Status();
            status.setId(fabricanteDTO.getStatusDTO().getId());
            status.setNome(fabricanteDTO.getStatusDTO().getNome());
            status.setCodigo(fabricanteDTO.getStatusDTO().getCodigo());
            fabricante.setStatus(status);
        }

        return fabricante;
    }
}
