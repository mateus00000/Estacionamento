package com.example.estacionamento.dto;

public class FabricanteDTO {
    private Long id;
    private String nome;
    private String nacionalidade;
    private StatusDTO statusDTO;
    
    public FabricanteDTO() {
    }

    public FabricanteDTO(Long id, String nome, String nacionalidade, StatusDTO statusDTO) {
        this.id = id;
        this.nome = nome;
        this.nacionalidade = nacionalidade;
        this.statusDTO = statusDTO;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNacionalidade() {
        return nacionalidade;
    }

    public void setNacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade;
    }

    public StatusDTO getStatusDTO() {
        return statusDTO;
    }

    public void setStatusDTO(StatusDTO statusDTO) {
        this.statusDTO = statusDTO;
    }
}
