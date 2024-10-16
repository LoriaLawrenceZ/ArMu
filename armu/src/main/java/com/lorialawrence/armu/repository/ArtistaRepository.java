package com.lorialawrence.armu.repository;

import com.lorialawrence.armu.model.Artista;
import com.lorialawrence.armu.model.Musica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ArtistaRepository extends JpaRepository<Artista, Long> {
    Optional<Artista> findByNomeContainingIgnoreCase(String pNomeArtista);

    @Query("SELECT m FROM Artista a JOIN a.musicas m WHERE a.nome ILIKE %:pNomeArtista%")
    List<Musica> buscarMusicasPorArtista(String pNomeArtista);
}
