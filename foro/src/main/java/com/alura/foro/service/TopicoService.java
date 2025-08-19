package com.alura.foro.service;

import com.alura.foro.repository.CursoRepository;
import com.alura.foro.repository.TopicoRepository;
import com.alura.foro.repository.UsuarioRepository;
import com.alura.foro.dto.TopicoDTO;
import com.alura.foro.model.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TopicoService {

    private final TopicoRepository topicoRepository;
    private final UsuarioRepository usuarioRepository;
    private final CursoRepository cursoRepository;

    public TopicoService(TopicoRepository topicoRepository, UsuarioRepository usuarioRepository, CursoRepository cursoRepository) {
        this.topicoRepository = topicoRepository;
        this.usuarioRepository = usuarioRepository;
        this.cursoRepository = cursoRepository;
    }

    @Transactional
    public Topico crearTopico(TopicoDTO dto) {
        if (topicoRepository.findByTituloAndMensaje(dto.titulo(), dto.mensaje()).isPresent()) {
            throw new IllegalArgumentException("El tópico ya existe");
        }

        Usuario autor = usuarioRepository.findById(dto.autorId())
                .orElseThrow(() -> new IllegalArgumentException("Autor no encontrado"));
        Curso curso = cursoRepository.findById(dto.cursoId())
                .orElseThrow(() -> new IllegalArgumentException("Curso no encontrado"));

        Topico topico = new Topico();
        topico.setTitulo(dto.titulo());
        topico.setMensaje(dto.mensaje());
        topico.setAutor(autor);
        topico.setCurso(curso);

        return topicoRepository.save(topico);
    }

    public List<Topico> listarTopicos() {
        return topicoRepository.findAll();
    }

    public Topico obtenerTopico(Long id) {
        return topicoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Tópico no encontrado"));
    }

    @Transactional
    public Topico actualizarTopico(Long id, TopicoDTO dto) {
        Topico topico = obtenerTopico(id);
        topico.setTitulo(dto.titulo());
        topico.setMensaje(dto.mensaje());
        return topicoRepository.save(topico);
    }

    @Transactional
    public void eliminarTopico(Long id) {
        if (!topicoRepository.existsById(id)) {
            throw new IllegalArgumentException("Tópico no encontrado");
        }
        topicoRepository.deleteById(id);
    }
}
