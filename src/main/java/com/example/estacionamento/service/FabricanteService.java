package com.example.estacionamento.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.estacionamento.dto.FabricanteDTO;
import com.example.estacionamento.entities.Fabricante;
import com.example.estacionamento.repository.FabricanteRepository;

import jakarta.servlet.http.HttpServletResponse;

@Service
public class FabricanteService {
    @Autowired
    private FabricanteRepository fabricanteRepository;

    public ResponseEntity <FabricanteDTO> criarFabricante(FabricanteDTO fabricanteDTO, HttpServletResponse response){

        Fabricante fabricante = FabricanteMapper.toEntity(fabricanteDTO); 
        FabricanteDTO fabricanteSalvoDTO = FabricanteMapper.toDTO(fabricanteRepository.save(fabricante));

        return ResponseEntity.ok(fabricanteSalvoDTO);
    }

    public List<FabricanteDTO> obterTodosFabricantes(){
        List<Fabricante> fabricantes = fabricanteRepository.findAll();
        List<FabricanteDTO> fabricantesDTOs = new ArrayList<>();
        for(Fabricante fabricante : fabricantes){
            fabricantesDTOs.add(FabricanteMapper.toDTO(fabricante));
        }    
        return fabricantesDTOs;
    }

    public Optional<FabricanteDTO> obterFabricantePorId(Long id){
        Optional<Fabricante> fabricante = fabricanteRepository.findById(id);
        if (fabricante.isPresent()) {
            return Optional.of(FabricanteMapper.toDTO(fabricante.get()));
        } else {
            return Optional.empty();
        }
    }
    public FabricanteDTO atualizarFabricante(Long id, FabricanteDTO fabricanteDTO) {
        Optional<Fabricante> fabricanteExistente = fabricanteRepository.findById(id);
        if (fabricanteExistente.isPresent()) {
            Fabricante fabricante = FabricanteMapper.toEntity(fabricanteDTO);
            fabricante.setId(id);
            fabricante = fabricanteRepository.save(fabricante);
            return FabricanteMapper.toDTO(fabricante);
        } else {
            return null;
        }
    }

    public boolean deletarFabricante(Long id) {
        Optional<Fabricante> fabricanteExistente = fabricanteRepository.findById(id);
        if(fabricanteExistente.isPresent()){
            fabricanteRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}
