package com.lorialawrence.armu.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "artistas")
public class Artista {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_artista")
    private Long id;
    private String nome;
    private int idade;
    private String terraNatal;
    @OneToMany(mappedBy = "artista", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Musica> musicas;

    public Artista () {}

    public Artista (String nome, int idade, String terraNatal) {
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

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }
    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getTerraNatal() {
        return terraNatal;
    }
    public void setTerraNatal(String terraNatal) {
        this.terraNatal = terraNatal;
    }

    public List<Musica> getMusicas() {
        return musicas;
    }
    public void setMusicas(List<Musica> musica) {
        this.musicas = musica;
    }

    @Override
    public String toString() {
        return "Artista: " + nome + "\n" + musicas;
    }
}
