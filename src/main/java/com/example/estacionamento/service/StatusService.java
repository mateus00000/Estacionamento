package com.example.estacionamento.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.estacionamento.dto.StatusDTO;
import com.example.estacionamento.entities.Status;
import com.example.estacionamento.repository.StatusRepository;
import com.example.estacionamento.util.StatusMapper;

import jakarta.servlet.http.HttpServletResponse;

@Service
public class StatusService {
    @Autowired
    private StatusRepository statusRepository;

    public ResponseEntity <StatusDTO> criarStatus(StatusDTO statusDTO, HttpServletResponse response){

        Status status = StatusMapper.toEntity(statusDTO); 
        StatusDTO statusSalvoDTO = StatusMapper.toDTO(statusRepository.save(status));

        return ResponseEntity.ok(statusSalvoDTO);
    }

    public List<StatusDTO> obterTodosStatus(){
        List<Status> statuses = statusRepository.findAll();
        List<StatusDTO> statusesDTOs = new ArrayList<>();
        for(Status status : statuses){
            statusesDTOs.add(StatusMapper.toDTO(status));
        }    
        return statusesDTOs;
    }

    public Optional<StatusDTO> obterStatusPorId(Long id){
        Optional<Status> status = statusRepository.findById(id);
        if (status.isPresent()) {
            return Optional.of(StatusMapper.toDTO(status.get()));
        } else {
            return Optional.empty();
        }
    }
    public StatusDTO atualizarStatus(Long id, StatusDTO statusDTO) {
        Optional<Status> statusExistente = statusRepository.findById(id);
        if (statusExistente.isPresent()) {
            Status status = StatusMapper.toEntity(statusDTO);
            status.setId(id);
            status = statusRepository.save(status);
            return StatusMapper.toDTO(status);
        } else {
            return null;
        }
    }

    public boolean deletarStatus(Long id) {
        Optional<Status> statusExistente = statusRepository.findById(id);
        if(statusExistente.isPresent()){
            statusRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}
