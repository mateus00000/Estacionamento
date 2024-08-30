package com.example.estacionamento.service;

import java.util.Optional;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.estacionamento.dto.VeiculoDTO;
import com.example.estacionamento.entities.Modelo;
import com.example.estacionamento.entities.Veiculo;
import com.example.estacionamento.repository.ModeloRepository;
import com.example.estacionamento.repository.VeiculoRepository;
import com.example.estacionamento.util.VeiculoMapper;

@Service
public class VeiculoService {
    private static final Logger logger = Logger.getLogger(VeiculoService.class.getName());

    @Autowired
    private VeiculoRepository veiculoRepository;

    @Autowired
    private ModeloRepository modeloRepository;

    public VeiculoDTO criarVeiculo(VeiculoDTO veiculoDTO) {
        logger.info("Criando Veiculo com VeiculoDTO: " + veiculoDTO);

        if (veiculoDTO == null) {
            logger.severe("VeiculoDTO é nulo.");
            throw new RuntimeException("VeiculoDTO é necessário para criar um Veiculo.");
        }

        Veiculo veiculo = VeiculoMapper.toEntity(veiculoDTO);

        if (veiculoDTO.getModeloDTO() != null && veiculoDTO.getModeloDTO().getId() != null) {
            Long idModelo = veiculoDTO.getModeloDTO().getId();
            logger.info("ID do Modelo recebido: " + idModelo);

            Optional<Modelo> modeloOptional = modeloRepository.findById(idModelo);
            if (modeloOptional.isPresent()) {
                veiculo.setModelo(modeloOptional.get());
            } else {
                throw new RuntimeException("Modelo com ID " + idModelo + " não localizado.");
            }
        } else {
            throw new RuntimeException("ModeloDTO e seu ID são necessários para criar um Veiculo.");
        }

        veiculo = veiculoRepository.save(veiculo);

        return VeiculoMapper.toDTO(veiculo);
    }
}
