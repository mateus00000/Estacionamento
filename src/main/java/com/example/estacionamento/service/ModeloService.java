package com.example.estacionamento.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.estacionamento.dto.ModeloDTO;
import com.example.estacionamento.entities.Fabricante;
import com.example.estacionamento.entities.Modelo;
import com.example.estacionamento.entities.Tipo;
import com.example.estacionamento.repository.FabricanteRepository;
import com.example.estacionamento.repository.ModeloRepository;
import com.example.estacionamento.repository.TipoRepository;
import com.example.estacionamento.util.ModeloMapper;

@Service
public class ModeloService {
    @Autowired
    private ModeloRepository modeloRepository;

    @Autowired
    private FabricanteRepository fabricanteRepository;

    @Autowired
    private TipoRepository tipoRepository;

    public ModeloDTO criarModelo(ModeloDTO modeloDTO) {
        // Converter DTO para entidade Modelo
        Modelo modelo = ModeloMapper.toEntity(modeloDTO);

        // Buscar e associar o Fabricante usando o ID
        if (modelo.getFabricante() != null && modelo.getFabricante().getId() != null) {
            Optional<Fabricante> fabricanteOptional = fabricanteRepository.findById(modelo.getFabricante().getId());
            if (fabricanteOptional.isPresent()) {
                modelo.setFabricante(fabricanteOptional.get());
            } else {
                throw new RuntimeException("Fabricante com ID " + modelo.getFabricante().getId() + " não encontrado.");
            }
        }
        if (modelo.getTipo() != null && modelo.getTipo().getId() != null) {
            Optional<Tipo> tipoOptional = tipoRepository.findById(modelo.getTipo().getId());
            if (tipoOptional.isPresent()) {
                modelo.setTipo(tipoOptional.get());
            } else {
                throw new RuntimeException("Tipo com ID " + modelo.getTipo().getId() + " não encontrado.");
            }
        }
        modelo = modeloRepository.save(modelo);
        return ModeloMapper.toDTO(modelo);
    }

    public List<ModeloDTO> obterTodosModelos() {
        return modeloRepository.findAll().stream()
                .map(ModeloMapper::toDTO)
                .collect(Collectors.toList());
    }

    public ModeloDTO obterModeloPorId(Long id) {
        return modeloRepository.findById(id)
                .map(ModeloMapper::toDTO)
                .orElseThrow(() -> new RuntimeException("Modelo não encontrado"));
    }

    public ModeloDTO atualizarModelo(Long id, ModeloDTO modeloDTO) {
        Modelo modeloExistente = modeloRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Modelo não encontrado"));

        modeloExistente.setNome(modeloDTO.getNome());
        Modelo modeloAtualizado = modeloRepository.save(modeloExistente);
        return ModeloMapper.toDTO(modeloAtualizado);
    }

    public boolean deletarModelo(Long id) {
        Optional<Modelo> modeloExistente = modeloRepository.findById(id);
        if(modeloExistente.isPresent()){
            modeloRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
    
}
