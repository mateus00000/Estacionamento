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

import com.example.estacionamento.dto.TipoDTO;
import com.example.estacionamento.service.TipoService;

import jakarta.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/tipos")
public class TipoController {
    @Autowired
    private TipoService tipoService;

    @PostMapping
    public ResponseEntity<TipoDTO> criarTipo(@RequestBody TipoDTO tipoDTO, HttpServletResponse response){
        return tipoService.criarTipo(tipoDTO, response);
    }

    @GetMapping
    public List<TipoDTO> obterTodosTipos() {
        
        return tipoService.obterTodosTipos();
    }

    @GetMapping("/{id}")
    public Optional<TipoDTO> obterTipoPorId(@PathVariable Long id){

        return tipoService.obterTipoPorId(id);
    }

    @PutMapping("/{id}")
    public Optional<TipoDTO> atualizarTipo(@PathVariable Long id, @RequestBody TipoDTO tipoDTO){
        
        return Optional.ofNullable(tipoService.atualizarTipo(id, tipoDTO));
    }

    @SuppressWarnings("rawtypes")
    @DeleteMapping("/{id}")
    public Optional deletarTipo(@PathVariable Long id) {
        return Optional.ofNullable(tipoService.deletarTipo(id));
    }
}
