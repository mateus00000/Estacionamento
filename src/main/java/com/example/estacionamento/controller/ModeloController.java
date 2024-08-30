package com.example.estacionamento.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.estacionamento.dto.ModeloDTO;
import com.example.estacionamento.service.ModeloService;

@RestController
@RequestMapping("/modelos")
public class ModeloController {
    
    @Autowired
    private ModeloService modeloService;

    @PostMapping
    public ModeloDTO criarModelo(@RequestBody ModeloDTO modeloDTO) {
        return modeloService.criarModelo(modeloDTO);

    }

    @GetMapping
    public List<ModeloDTO> obterTodosModelos() {
        
        return modeloService.obterTodosModelos();
    }

    @GetMapping("/{id}")
    public Optional<ModeloDTO> obterModeloPorId(@PathVariable Long id){

        return modeloService.obterModeloPorId(id);
    }

    @PutMapping("/{id}")
    public Optional<ModeloDTO> atualizarModelo(@PathVariable Long id, @RequestBody ModeloDTO modeloDTO){
        
        return Optional.ofNullable(modeloService.atualizarModelo(id, modeloDTO));
    }

    @SuppressWarnings("rawtypes")
    @DeleteMapping("/{id}")
    public Optional deletarModelo(@PathVariable Long id) {
        return Optional.ofNullable(modeloService.deletarModelo(id));
    }
}
