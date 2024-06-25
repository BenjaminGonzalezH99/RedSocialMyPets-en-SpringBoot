package com.generation.redsocialmypets.Controller;

import com.generation.redsocialmypets.Models.Publicacion;
import com.generation.redsocialmypets.Service.PublicacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/publicaciones")
public class PublicacionController {
    @Autowired
    private PublicacionService publicacionService;

    @GetMapping
    public ResponseEntity<List<Publicacion>> obtenerTodasLasPublicaciones() {
        List<Publicacion> publicaciones = publicacionService.obtenerTodasLasPublicaciones();
        return new ResponseEntity<>(publicaciones, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Publicacion> obtenerPublicacionPorId(@PathVariable Long id) {
        Publicacion publicacion = publicacionService.obtenerPublicacionPorId(id);
        return new ResponseEntity<>(publicacion, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Publicacion> crearPublicacion(@RequestBody Publicacion publicacion) {
        Publicacion newPublicacion = publicacionService.crearPublicacion(publicacion);
        return new ResponseEntity<>(newPublicacion, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Publicacion> actualizarPublicacion(@PathVariable Long id, @RequestBody Publicacion publicacion) {
        Publicacion updatedPublicacion = publicacionService.actualizarPublicacion(publicacion);
        return new ResponseEntity<>(updatedPublicacion, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarPublicacion(@PathVariable Long id) {
        publicacionService.eliminarPublicacion(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}