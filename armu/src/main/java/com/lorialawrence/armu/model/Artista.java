package com.lorialawrence.armu.model;

import jakarta.persistence.*;

@Entity
@Table(name = "artistas")
public class Artista {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long nome;
    private Long idade;
    private String terraNatal;

    public Artista () {}

    public Artista (Long nome, Long idade, String terraNatal) {
        this.nome = nome;
        this.idade = idade;
        this.terraNatal = terraNatal;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public Long getNome() {
        return nome;
    }
    public void setNome(Long nome) {
        this.nome = nome;
    }

    public Long getIdade() {
        return idade;
    }
    public void setIdade(Long idade) {
        this.idade = idade;
    }

    public String getTerraNatal() {
        return terraNatal;
    }
    public void setTerraNatal(String terraNatal) {
        this.terraNatal = terraNatal;
    }
}
