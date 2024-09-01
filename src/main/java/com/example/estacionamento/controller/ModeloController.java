package com.example.estacionamento.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<List<ModeloDTO>> obterTodosModelos() {
        List<ModeloDTO> modelos = modeloService.obterTodosModelos();
        return ResponseEntity.ok(modelos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ModeloDTO> obterModeloPorId(@PathVariable Long id) {
        ModeloDTO modelo = modeloService.obterModeloPorId(id);
        return ResponseEntity.ok(modelo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ModeloDTO> atualizarModelo(@PathVariable Long id, @RequestBody ModeloDTO modeloDTO) {
        ModeloDTO modeloAtualizado = modeloService.atualizarModelo(id, modeloDTO);
        return ResponseEntity.ok(modeloAtualizado);
    }

    @SuppressWarnings("rawtypes")
    @DeleteMapping("/{id}")
    public Optional deletarModelo(@PathVariable Long id) {
        return Optional.ofNullable(modeloService.deletarModelo(id));
    }
}
