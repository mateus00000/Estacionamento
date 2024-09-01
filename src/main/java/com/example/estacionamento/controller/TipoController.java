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

@RestController
@RequestMapping("/tipos")
public class TipoController {
    @Autowired
    private TipoService tipoService;

    @PostMapping
    public TipoDTO criarTipo(@RequestBody TipoDTO tipoDTO) {
        return tipoService.criarTipo(tipoDTO);

    }

    @GetMapping
    public ResponseEntity<List<TipoDTO>> obterTodosTipos() {
        List<TipoDTO> tipos = tipoService.obterTodosTipos();
        return ResponseEntity.ok(tipos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TipoDTO> obterTipoPorId(@PathVariable Long id) {
        TipoDTO tipo = tipoService.obterTipoPorId(id);
        return ResponseEntity.ok(tipo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TipoDTO> atualizarTipo(@PathVariable Long id, @RequestBody TipoDTO tipoDTO) {
        TipoDTO tipoAtualizado = tipoService.atualizarTipo(id, tipoDTO);
        return ResponseEntity.ok(tipoAtualizado);
    }

    @SuppressWarnings("rawtypes")
    @DeleteMapping("/{id}")
    public Optional deletarTipo(@PathVariable Long id) {
        return Optional.ofNullable(tipoService.deletarTipo(id));
    }
}
