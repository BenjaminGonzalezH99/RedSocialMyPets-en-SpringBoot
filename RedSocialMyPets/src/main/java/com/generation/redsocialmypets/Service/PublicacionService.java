package com.generation.redsocialmypets.Service;

import com.generation.redsocialmypets.Models.Publicacion;
import com.generation.redsocialmypets.Repository.PublicacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PublicacionService {
    @Autowired
    private PublicacionRepository publicacionRepository;

    public List<Publicacion> obtenerTodasLasPublicaciones() {
        return publicacionRepository.findAll();
    }

    public Publicacion obtenerPublicacionPorId(Long id) {
        return publicacionRepository.findById(id).orElseThrow();
    }

    public Publicacion crearPublicacion(Publicacion publicacion) {
        return publicacionRepository.save(publicacion);
    }

    public Publicacion actualizarPublicacion(Publicacion publicacion) {
        return publicacionRepository.save(publicacion);
    }

    public void eliminarPublicacion(Long id) {
        publicacionRepository.deleteById(id);
    }
}