package com.alura.foro.controller;

import com.alura.foro.dto.TopicoDTO;
import com.alura.foro.model.Topico;
import com.alura.foro.service.TopicoService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/topicos")
public class TopicoController {

    private final TopicoService topicoService;

    public TopicoController(TopicoService topicoService) {
        this.topicoService = topicoService;
    }

    @PostMapping
    public ResponseEntity<Topico> crear(@RequestBody @Valid TopicoDTO dto) {
        return ResponseEntity.ok(topicoService.crearTopico(dto));
    }

    @GetMapping
    public ResponseEntity<List<Topico>> listar() {
        return ResponseEntity.ok(topicoService.listarTopicos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Topico> obtener(@PathVariable Long id) {
        return ResponseEntity.ok(topicoService.obtenerTopico(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Topico> actualizar(@PathVariable Long id, @RequestBody @Valid TopicoDTO dto) {
        return ResponseEntity.ok(topicoService.actualizarTopico(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        topicoService.eliminarTopico(id);
        return ResponseEntity.noContent().build();
    }
}

