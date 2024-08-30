package com.example.estacionamento.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
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
}
