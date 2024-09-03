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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.estacionamento.dto.FabricanteDTO;
import com.example.estacionamento.entities.Fabricante;
import com.example.estacionamento.service.FabricanteService;

@RestController
@RequestMapping("/fabricantes")
public class FabricanteController {
    @Autowired
    private FabricanteService fabricanteService;

    @PostMapping
    public FabricanteDTO criarFabricante(@RequestBody FabricanteDTO fabricanteDTO) {
        return fabricanteService.criarFabricante(fabricanteDTO);

    }

    @GetMapping
    public List<FabricanteDTO> obterTodosFabricantes() {
        
        return fabricanteService.obterTodosFabricantes();
    }

    @GetMapping("/{id}")
    public ResponseEntity<FabricanteDTO> obterFabricantePorId(@PathVariable Long id) {
        FabricanteDTO fabricante = fabricanteService.obterFabricantePorId(id);
        return ResponseEntity.ok(fabricante);
    }

    @PutMapping("/{id}")
    public Optional<FabricanteDTO> atualizarFabricante(@PathVariable Long id, @RequestBody FabricanteDTO fabricanteDTO){
        
        return Optional.ofNullable(fabricanteService.atualizarFabricante(id, fabricanteDTO));
    }

    @SuppressWarnings("rawtypes")
    @DeleteMapping("/{id}")
    public Optional deletarFabricante(@PathVariable Long id) {
        return Optional.ofNullable(fabricanteService.deletarFabricante(id));
    }

    @GetMapping("/nacionalidade")
    public List<Fabricante> buscarPorNacionalidade(@RequestParam String nacionalidade) {
        return fabricanteService.encontrarPorNacionalidade(nacionalidade);
    }

    // Endpoint para contar fabricantes por nacionalidade
    @GetMapping("/count/nacionalidade")
    public long contarPorNacionalidade(@RequestParam String nacionalidade) {
        return fabricanteService.contarPorNacionalidade(nacionalidade);
    }
}
