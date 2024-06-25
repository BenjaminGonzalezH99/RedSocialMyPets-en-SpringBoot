package com.generation.redsocialmypets.Service;

import com.generation.redsocialmypets.Models.Comentario;
import com.generation.redsocialmypets.Repository.ComentarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComentarioService {
    @Autowired
    private ComentarioRepository comentarioRepository;

    public List<Comentario> obtenerTodosLosComentarios() {
        return comentarioRepository.findAll();
    }

    public Comentario obtenerComentarioPorId(Long id) {
        return comentarioRepository.findById(id).orElseThrow();
    }

    public Comentario crearComentario(Comentario comentario) {
        return comentarioRepository.save(comentario);
    }

    public Comentario actualizarComentario(Comentario comentario) {
        return comentarioRepository.save(comentario);
    }

    public void eliminarComentario(Long id) {
        comentarioRepository.deleteById(id);
    }
}