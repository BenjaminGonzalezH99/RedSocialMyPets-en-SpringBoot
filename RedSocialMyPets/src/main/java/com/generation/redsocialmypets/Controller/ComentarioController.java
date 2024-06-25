package com.generation.redsocialmypets.Controller;

import com.generation.redsocialmypets.Models.Comentario;
import com.generation.redsocialmypets.Service.ComentarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/comentarios")
public class ComentarioController {
    @Autowired
    private ComentarioService comentarioService;

    @GetMapping
    public ResponseEntity<List<Comentario>> obtenerTodosLosComentarios() {
        List<Comentario> comentarios = comentarioService.obtenerTodosLosComentarios();
        return new ResponseEntity<>(comentarios, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Comentario> obtenerComentarioPorId(@PathVariable Long id) {
        Comentario comentario = comentarioService.obtenerComentarioPorId(id);
        return new ResponseEntity<>(comentario, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Comentario> crearComentario(@RequestBody Comentario comentario) {
        Comentario newComentario = comentarioService.crearComentario(comentario);
        return new ResponseEntity<>(newComentario, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Comentario> actualizarComentario(@PathVariable Long id, @RequestBody Comentario comentario) {
        Comentario updatedComentario = comentarioService.actualizarComentario(comentario);
        return new ResponseEntity<>(updatedComentario, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarComentario(@PathVariable Long id) {
        comentarioService.eliminarComentario(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}