package com.lorialawrence.armu.repository;

import com.lorialawrence.armu.model.Musica;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MusicaRepository extends JpaRepository<Musica, Long> {
    Optional<Musica> findByNomeContainingIgnoreCase(String nomeMusica);
}
