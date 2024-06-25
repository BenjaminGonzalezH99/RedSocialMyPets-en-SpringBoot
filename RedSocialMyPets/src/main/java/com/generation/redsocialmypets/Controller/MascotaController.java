package com.generation.redsocialmypets.Controller;

import com.generation.redsocialmypets.Models.Mascota;
import com.generation.redsocialmypets.Service.MascotaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/mascotas")
public class MascotaController {
    @Autowired
    private MascotaService mascotaService;

    @GetMapping
    public ResponseEntity<List<Mascota>> getAllMascotas() {
        List<Mascota> mascotas = mascotaService.getAllMascotas();
        return new ResponseEntity<>(mascotas, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Mascota> getMascotaById(@PathVariable Long id) {
        Mascota mascota = mascotaService.getMascotaById(id);
        return new ResponseEntity<>(mascota, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Mascota> createMascota(@RequestBody Mascota mascota) {
        Mascota newMascota = mascotaService.createMascota(mascota);
        return new ResponseEntity<>(newMascota, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Mascota> updateMascota(@PathVariable Long id, @RequestBody Mascota mascota) {
        Mascota updatedMascota = mascotaService.updateMascota(mascota);
        return new ResponseEntity<>(updatedMascota, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMascota(@PathVariable Long id) {
        mascotaService.deleteMascota(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}