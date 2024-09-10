package com.lorialawrence.armu.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "musicas")
public class Musica {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_musica")
    private Long id;
    private String nome;
    @Enumerated(EnumType.STRING)
    private Genero genero;
    private String duracao;
    private String letra;
    private LocalDate dataLancamento;
    @ManyToOne
    @JoinColumn(name = "id_artista")
    private Artista artista;

    public Musica () {}

    public Musica (String nome, Genero genero, String duracao, String letra, LocalDate dataLancamento, Artista artista) {
        this.nome = nome;
        this.genero = genero;
        this.duracao = duracao;
        this.letra = letra;
        this.dataLancamento = dataLancamento;
        this.artista = artista;
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

    public Genero getGenero() {
        return genero;
    }
    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public String getDuracao() {
        return duracao;
    }
    public void setDuracao(String duracao) {
        this.duracao = duracao;
    }

    public String getLetra() {
        return letra;
    }
    public void setLetra(String letra) {
        this.letra = letra;
    }

    public LocalDate getDataLancamento() {
        return dataLancamento;
    }
    public void setDataLancamento(LocalDate dataLancamento) {
        this.dataLancamento = dataLancamento;
    }

    public Artista getArtista() {
        return artista;
    }
    public void setArtista(Artista artista) {
        this.artista = artista;
    }

    @Override
    public String toString() {
        return """
                Música: %s
                    - Gênero: %s
                    - Duração: %s
                    - Data de lançamento: %s
                    - Artista: %s
                    - Letra: %s
                """.formatted(nome, genero, duracao, dataLancamento, artista.getNome(), letra);
    }
}
