package com.example.estacionamento.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.estacionamento.dto.TipoDTO;
import com.example.estacionamento.entities.Tipo;
import com.example.estacionamento.repository.TipoRepository;
import com.example.estacionamento.util.TipoMapper;

import jakarta.servlet.http.HttpServletResponse;

@Service
public class TipoService {
    @Autowired
    private TipoRepository tipoRepository;

    public ResponseEntity <TipoDTO> criarTipo(TipoDTO tipoDTO, HttpServletResponse response){

        Tipo tipo = TipoMapper.toEntity(tipoDTO); 
        TipoDTO tipoSalvoDTO = TipoMapper.toDTO(tipoRepository.save(tipo));

        return ResponseEntity.ok(tipoSalvoDTO);
    }

    public List<TipoDTO> obterTodosTipos(){
        List<Tipo> tipos = tipoRepository.findAll();
        List<TipoDTO> tiposDTOs = new ArrayList<>();
        for(Tipo tipo : tipos){
            tiposDTOs.add(TipoMapper.toDTO(tipo));
        }    
        return tiposDTOs;
    }

    public Optional<TipoDTO> obterTipoPorId(Long id){
        Optional<Tipo> tipo = tipoRepository.findById(id);
        if (tipo.isPresent()) {
            return Optional.of(TipoMapper.toDTO(tipo.get()));
        } else {
            return Optional.empty();
        }
    }
    public TipoDTO atualizarTipo(Long id, TipoDTO tipoDTO) {
        Optional<Tipo> tipoExistente = tipoRepository.findById(id);
        if (tipoExistente.isPresent()) {
            Tipo tipo = TipoMapper.toEntity(tipoDTO);
            tipo.setId(id);
            tipo = tipoRepository.save(tipo);
            return TipoMapper.toDTO(tipo);
        } else {
            return null;
        }
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
