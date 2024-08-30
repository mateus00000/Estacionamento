package com.example.estacionamento.service;

import java.util.ArrayList;
import java.util.List;
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

    public List<VeiculoDTO> obterTodosVeiculos(){
        List<Veiculo> veiculos = veiculoRepository.findAll();
        List<VeiculoDTO> veiculosDTOs = new ArrayList<>();
        for(Veiculo veiculo : veiculos){
            veiculosDTOs.add(VeiculoMapper.toDTO(veiculo));
        }    
        return veiculosDTOs;
    }

    public Optional<VeiculoDTO> obterVeiculoPorId(Long id){
        Optional<Veiculo> veiculo = veiculoRepository.findById(id);
        if (veiculo.isPresent()) {
            return Optional.of(VeiculoMapper.toDTO(veiculo.get()));
        } else {
            return Optional.empty();
        }
    }
    public VeiculoDTO atualizarVeiculo(Long id, VeiculoDTO veiculoDTO) {
        Optional<Veiculo> veiculoExistente = veiculoRepository.findById(id);
        if (veiculoExistente.isPresent()) {
            Veiculo veiculo = VeiculoMapper.toEntity(veiculoDTO);
            veiculo.setId(id);
            veiculo = veiculoRepository.save(veiculo);
            return VeiculoMapper.toDTO(veiculo);
        } else {
            return null;
        }
    }

    public boolean deletarVeiculo(Long id) {
        Optional<Veiculo> veiculoExistente = veiculoRepository.findById(id);
        if(veiculoExistente.isPresent()){
            veiculoRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}
