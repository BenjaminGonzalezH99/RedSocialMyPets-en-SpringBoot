package com.generation.redsocialmypets.Service;

import com.generation.redsocialmypets.Models.Mascota;
import com.generation.redsocialmypets.Repository.MascotaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MascotaService {
    @Autowired
    private MascotaRepository mascotaRepository;

    public List<Mascota> getAllMascotas() {
        return mascotaRepository.findAll();
    }

    public Mascota getMascotaById(Long id) {
        return mascotaRepository.findById(id).orElseThrow();
    }

    public Mascota createMascota(Mascota mascota) {
        return mascotaRepository.save(mascota);
    }

    public Mascota updateMascota(Mascota mascota) {
        return mascotaRepository.save(mascota);
    }

    public void deleteMascota(Long id) {
        mascotaRepository.deleteById(id);
    }
}