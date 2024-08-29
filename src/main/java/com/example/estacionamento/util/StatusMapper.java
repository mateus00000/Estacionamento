package com.example.estacionamento.util;

import com.example.estacionamento.dto.StatusDTO;
import com.example.estacionamento.entities.Status;

public class StatusMapper {

    public static StatusDTO toDTO(Status status){
        return new StatusDTO(status.getId(), status.getNome(), status.getCodigo());
    }     

    public static Status toEntity(StatusDTO statusDTO){
        Status status = new Status();
        status.setId(statusDTO.getId());
        status.setNome(statusDTO.getNome());
        status.setCodigo(statusDTO.getCodigo());

        return status;
    }
}
