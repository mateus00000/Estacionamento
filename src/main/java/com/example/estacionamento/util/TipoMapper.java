package com.example.estacionamento.util;

import com.example.estacionamento.dto.TipoDTO;
import com.example.estacionamento.entities.Tipo;

public class TipoMapper {
    public static TipoDTO toDTO(Tipo tipo){
        return new TipoDTO(tipo.getId(), tipo.getNome());
}     

    public static Tipo toEntity(TipoDTO tipoDTO){
        Tipo tipo = new Tipo();
        tipo.setId(tipoDTO.getId());
        tipo.setNome(tipoDTO.getNome());

        return tipo;
    }
}
