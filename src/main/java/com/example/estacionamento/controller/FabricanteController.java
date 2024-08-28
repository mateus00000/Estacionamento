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

import com.example.estacionamento.dto.FabricanteDTO;
import com.example.estacionamento.service.FabricanteService;

import jakarta.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/fabricantes")
public class FabricanteController {
    @Autowired
    private FabricanteService fabricanteService;

    @PostMapping
    public ResponseEntity<FabricanteDTO> criarFabricante(@RequestBody FabricanteDTO fabricanteDTO, HttpServletResponse response){
        return fabricanteService.criarFabricante(fabricanteDTO, response);
    }

    @GetMapping
    public List<FabricanteDTO> obterTodosFabricantes() {
        
        return fabricanteService.obterTodosFabricantes();
    }

    @GetMapping("/{id}")
    public Optional<FabricanteDTO> obterFabricantePorId(@PathVariable Long id){

        return fabricanteService.obterFabricantePorId(id);
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
}
