package com.alura.foro.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.alura.foro.model.Topico;

import java.util.Optional;

public interface TopicoRepository extends JpaRepository<Topico, Long> {
    Optional<Topico> findByTituloAndMensaje(String titulo, String mensaje);
}