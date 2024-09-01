package com.example.estacionamento.service;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.estacionamento.dto.VeiculoDTO;
import com.example.estacionamento.entities.Modelo;
import com.example.estacionamento.entities.Veiculo;
import com.example.estacionamento.repository.ModeloRepository;
import com.example.estacionamento.repository.VeiculoRepository;
import com.example.estacionamento.util.ValidaPlaca;
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
        if (!ValidaPlaca.validaPlaca(veiculoDTO.getPlaca())) {
            logger.severe("Placa inválida.");
            throw new RuntimeException("Placa inválida.");
        }

        Veiculo veiculo = VeiculoMapper.toEntity(veiculoDTO);

        if (veiculoDTO.getModeloDTO() != null && veiculoDTO.getModeloDTO().getId() != null) {
            Long idModelo = veiculoDTO.getModeloDTO().getId();
            logger.info("ID do Modelo recebido: " + idModelo);

            Optional<Modelo> modeloOptional = modeloRepository.findById(idModelo);
            if (modeloOptional.isPresent()) {
                veiculo.setModelo(modeloOptional.get());
            } else {
                throw new RuntimeException("Modelo com ID " + idModelo + " não encontrado.");
            }
        } else {
            throw new RuntimeException("ModeloDTO e seu ID são necessários para criar um Veiculo.");
        }

        veiculo = veiculoRepository.save(veiculo);

        return VeiculoMapper.toDTO(veiculo);
    }

    public List<VeiculoDTO> obterTodosVeiculos() {
        logger.info("Listando Veiculos");

        return veiculoRepository.findAll().stream()
                .map(VeiculoMapper::toDTO)
                .collect(Collectors.toList());
    }

    public VeiculoDTO obterVeiculoPorId(Long id) {
        logger.info("Buscando Veiculo com ID: " + id);

        Optional<Veiculo> veiculoOptional = veiculoRepository.findById(id);

        if (veiculoOptional.isPresent()) {
            return VeiculoMapper.toDTO(veiculoOptional.get());
        } else {
            throw new RuntimeException("Veiculo com ID " + id + " não encontrado.");
        }
    }

    public VeiculoDTO atualizarVeiculo(Long id, VeiculoDTO veiculoDTO) {
        logger.info("Atualizando Veiculo com ID: " + id);

        Optional<Veiculo> veiculoOptional = veiculoRepository.findById(id);

        if (veiculoOptional.isPresent()) {
            Veiculo veiculo = veiculoOptional.get();
            veiculo.setPlaca(veiculoDTO.getPlaca());
            veiculo.setCor(veiculoDTO.getCor());
            veiculo.setAno(veiculoDTO.getAno());

            if (veiculoDTO.getModeloDTO() != null && veiculoDTO.getModeloDTO().getId() != null) {
                Long idModelo = veiculoDTO.getModeloDTO().getId();
                logger.info("ID do Modelo recebido: " + idModelo);

                Optional<Modelo> modeloOptional = modeloRepository.findById(idModelo);
                if (modeloOptional.isPresent()) {
                    veiculo.setModelo(modeloOptional.get());
                } else {
                    throw new RuntimeException("Modelo com ID " + idModelo + " não encontrado.");
                }
            } else {
                throw new RuntimeException("ModeloDTO e seu ID são necessários para atualizar um Veiculo.");
            }

            veiculo = veiculoRepository.save(veiculo);

            return VeiculoMapper.toDTO(veiculo);
        } else {
            throw new RuntimeException("Veiculo com ID " + id + " não encontrado.");
        }
    }

    public void deletarVeiculo(Long id) {
        logger.info("Deletando Veiculo com ID: " + id);

        Optional<Veiculo> veiculoOptional = veiculoRepository.findById(id);

        if (veiculoOptional.isPresent()) {
            veiculoRepository.deleteById(id);
        } else {
            throw new RuntimeException("Veiculo com ID " + id + " não encontrado.");
        }
    }
}
