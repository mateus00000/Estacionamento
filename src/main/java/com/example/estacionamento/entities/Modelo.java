package com.example.estacionamento.entities;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class Modelo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;

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

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "fabricante_id", referencedColumnName = "id")
    private Fabricante fabricante;

    public Fabricante getFabricante() {
        return fabricante;
    }

    public void setFabricante(Fabricante fabricante){
        this.fabricante = fabricante;
    }

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "tipo_id", referencedColumnName = "id")
    private Tipo tipo;

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo){
        this.tipo = tipo;
    }
    
}
