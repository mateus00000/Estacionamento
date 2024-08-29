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

import com.example.estacionamento.dto.StatusDTO;
import com.example.estacionamento.service.StatusService;

import jakarta.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/status")
public class StatusController {
    @Autowired
    private StatusService statusService;

    @PostMapping
    public ResponseEntity<StatusDTO> criarStatus(@RequestBody StatusDTO statusDTO, HttpServletResponse response){
        return statusService.criarStatus(statusDTO, response);
    }

    @GetMapping
    public List<StatusDTO> obterTodosStatus() {
        
        return statusService.obterTodosStatus();
    }

    @GetMapping("/{id}")
    public Optional<StatusDTO> obterStatusPorId(@PathVariable Long id){

        return statusService.obterStatusPorId(id);
    }

    @PutMapping("/{id}")
    public Optional<StatusDTO> atualizarStatus(@PathVariable Long id, @RequestBody StatusDTO statusDTO){
        
        return Optional.ofNullable(statusService.atualizarStatus(id, statusDTO));
    }

    @SuppressWarnings("rawtypes")
    @DeleteMapping("/{id}")
    public Optional deletarStatus(@PathVariable Long id) {
        return Optional.ofNullable(statusService.deletarStatus(id));
    }
}
