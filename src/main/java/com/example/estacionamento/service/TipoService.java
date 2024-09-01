package com.example.estacionamento.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.estacionamento.dto.TipoDTO;
import com.example.estacionamento.entities.Tipo;
import com.example.estacionamento.repository.TipoRepository;
import com.example.estacionamento.util.TipoMapper;

@Service
public class TipoService {
    @Autowired
    private TipoRepository tipoRepository;

    public TipoDTO criarTipo(TipoDTO tipoDTO) {
        Tipo tipo = TipoMapper.toEntity(tipoDTO);
        tipo = tipoRepository.save(tipo);
        return TipoMapper.toDTO(tipo);
    }

    public List<TipoDTO> obterTodosTipos() {
        return tipoRepository.findAll().stream()
                .map(TipoMapper::toDTO)
                .collect(Collectors.toList());
    }

    public TipoDTO obterTipoPorId(Long id) {
        return tipoRepository.findById(id)
                .map(TipoMapper::toDTO)
                .orElseThrow(() -> new RuntimeException("Tipo não encontrado"));
    }

    public TipoDTO atualizarTipo(Long id, TipoDTO tipoDTO) {
        Tipo tipoExistente = tipoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Tipo não encontrado"));

        tipoExistente.setNome(tipoDTO.getNome());
        Tipo tipoAtualizado = tipoRepository.save(tipoExistente);
        return TipoMapper.toDTO(tipoAtualizado);
    }

    public boolean deletarTipo(Long id) {
        Optional<Tipo> tipoExistente = tipoRepository.findById(id);
        if(tipoExistente.isPresent()){
            tipoRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}
