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

import com.example.estacionamento.dto.VeiculoDTO;
import com.example.estacionamento.service.VeiculoService;

@RestController
@RequestMapping("/veiculos")
public class VeiculoController {
    @Autowired
    private VeiculoService veiculoService;

    @PostMapping
    public ResponseEntity<VeiculoDTO> criarVeiculo(@RequestBody VeiculoDTO veiculoDTO) {
        VeiculoDTO novoVeiculo = veiculoService.criarVeiculo(veiculoDTO);
        return ResponseEntity.ok(novoVeiculo);
    }

    @GetMapping
    public List<VeiculoDTO> obterTodosVeiculos() {
        
        return veiculoService.obterTodosVeiculos();
    }

    @GetMapping("/{id}")
    public Optional<VeiculoDTO> obterVeiculoPorId(@PathVariable Long id){

        return veiculoService.obterVeiculoPorId(id);
    }

    @PutMapping("/{id}")
    public Optional<VeiculoDTO> atualizarVeiculo(@PathVariable Long id, @RequestBody VeiculoDTO veiculoDTO){
        
        return Optional.ofNullable(veiculoService.atualizarVeiculo(id, veiculoDTO));
    }

    @SuppressWarnings("rawtypes")
    @DeleteMapping("/{id}")
    public Optional deletarVeiculo(@PathVariable Long id) {
        return Optional.ofNullable(veiculoService.deletarVeiculo(id));
    }
}
