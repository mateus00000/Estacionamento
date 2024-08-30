package com.example.estacionamento.dto;

public class VeiculoDTO {
    private Long id;
    private String placa;
    private String cor;
    private String ano;
    private ModeloDTO modeloDTO;
    
    public VeiculoDTO() {
    }

    public VeiculoDTO(Long id, String placa, String cor, String ano, ModeloDTO modeloDTO) {
        this.id = id;
        this.placa = placa;
        this.cor = cor;
        this.ano = ano;
        this.modeloDTO = modeloDTO;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }

    public ModeloDTO getModeloDTO() {
        return modeloDTO;
    }

    public void setModeloDTO(ModeloDTO modeloDTO) {
        this.modeloDTO = modeloDTO;
    }
}
