package com.generation.redsocialmypets.Service;

import com.generation.redsocialmypets.Models.Like;
import com.generation.redsocialmypets.Repository.LikeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LikeService {
    @Autowired
    private LikeRepository LikeRepository;

    public List<Like> obtenerTodosLosMeGusta() {
        return LikeRepository.findAll();
    }

    public Like obtenerMeGustaPorId(Long id) {
        return LikeRepository.findById(id).orElseThrow();
    }

    public Like crearMeGusta(Like Like) {
        return LikeRepository.save(Like);
    }

    public Like actualizarMeGusta(Like Like) {
        return LikeRepository.save(Like);
    }

    public void eliminarMeGusta(Long id) {
        LikeRepository.deleteById(id);
    }
}