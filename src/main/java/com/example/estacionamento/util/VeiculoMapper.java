package com.example.estacionamento.util;

import com.example.estacionamento.dto.ModeloDTO;
import com.example.estacionamento.dto.VeiculoDTO;
import com.example.estacionamento.entities.Modelo;
import com.example.estacionamento.entities.Veiculo;

public class VeiculoMapper {
    public static VeiculoDTO toDTO(Veiculo veiculo) {
        if (veiculo == null) {
            return null;
        }

        ModeloDTO modeloDTO = ModeloMapper.toDTO(veiculo.getModelo());

        return new VeiculoDTO(
            veiculo.getId(),
            veiculo.getPlaca(),
            veiculo.getCor(),
            veiculo.getAno(),
            modeloDTO
        );
    }

    public static Veiculo toEntity(VeiculoDTO dto) {
        if (dto == null) {
            return null;
        }

        Veiculo veiculo = new Veiculo();
        veiculo.setId(dto.getId());
        veiculo.setPlaca(dto.getPlaca());
        veiculo.setCor(dto.getCor());
        veiculo.setAno(dto.getAno());

        if (dto.getModeloDTO() != null && dto.getModeloDTO().getId() != null) {
            Modelo modelo = new Modelo();
            modelo.setId(dto.getModeloDTO().getId());
            veiculo.setModelo(modelo);
        }

        return veiculo;
    }
}
