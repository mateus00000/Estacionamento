package com.example.estacionamento.util;

import com.example.estacionamento.dto.FabricanteDTO;
import com.example.estacionamento.dto.StatusDTO;
import com.example.estacionamento.entities.Fabricante;
import com.example.estacionamento.entities.Status;

public class FabricanteMapper {
    public static FabricanteDTO toDTO(Fabricante fabricante) {
        if (fabricante == null) {
            return null;
        }

        // Use StatusMapper para converter Status para StatusDTO
        StatusDTO statusDTO = StatusMapper.toDTO(fabricante.getStatus());

        return new FabricanteDTO(
            fabricante.getId(),
            fabricante.getNome(),
            fabricante.getNacionalidade(),
            statusDTO
        );
    }

    public static Fabricante toEntity(FabricanteDTO dto) {
        if (dto == null) {
            return null;
        }

        Fabricante fabricante = new Fabricante();
        fabricante.setId(dto.getId());
        fabricante.setNome(dto.getNome());
        fabricante.setNacionalidade(dto.getNacionalidade());

        if (dto.getStatusDTO() != null && dto.getStatusDTO().getId() != null) {
            Status status = new Status();
            status.setId(dto.getStatusDTO().getId());
            fabricante.setStatus(status);
        }

        return fabricante;
    }
}
