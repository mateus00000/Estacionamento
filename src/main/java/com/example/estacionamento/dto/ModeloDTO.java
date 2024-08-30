package com.example.estacionamento.dto;

public class ModeloDTO {
    
    private Long id;
    private String nome;
    private FabricanteDTO fabricanteDTO;
    private TipoDTO tipoDTO;
    
    public ModeloDTO() {
    }

    public ModeloDTO(Long id, String nome, FabricanteDTO fabricanteDTO, TipoDTO tipoDTO) {
        this.id = id;
        this.nome = nome;
        this.fabricanteDTO = fabricanteDTO;
        this.tipoDTO = tipoDTO;
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

    public FabricanteDTO getFabricanteDTO() {
        return fabricanteDTO;
    }

    public void setFabricanteDTO(FabricanteDTO fabricanteDTO) {
        this.fabricanteDTO = fabricanteDTO;
    }

    public TipoDTO getTipoDTO() {
        return tipoDTO;
    }

    public void setTipoDTO(TipoDTO tipoDTO) {
        this.tipoDTO = tipoDTO;
    }
}
