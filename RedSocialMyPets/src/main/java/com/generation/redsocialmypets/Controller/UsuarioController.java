package com.generation.redsocialmypets.Controller;

import com.generation.redsocialmypets.DTO.usuarioDTO;
import com.generation.redsocialmypets.Service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public ResponseEntity<List<usuarioDTO>> getAllUsuarios() {
        List<usuarioDTO> usuarios = usuarioService.getUsuarios();
        return new ResponseEntity<>(usuarios, HttpStatus.OK);
    }

    @GetMapping("/nombre/{nombre}")
    public ResponseEntity<List<usuarioDTO>> getUsuariosByNombre(@PathVariable String nombre) {
        List<usuarioDTO> usuarios = usuarioService.getUsuariosByNombre(nombre);
        return new ResponseEntity<>(usuarios, HttpStatus.OK);
    }

    @GetMapping("/apellido/{apellido}")
    public ResponseEntity<List<usuarioDTO>> getUsuariosByApellido(@PathVariable String apellido) {
        List<usuarioDTO> usuarios = usuarioService.getUsuariosByApellido(apellido);
        return new ResponseEntity<>(usuarios, HttpStatus.OK);
    }

    @GetMapping("/email/{email}")
    public ResponseEntity<List<usuarioDTO>> getUsuariosByEmail(@PathVariable String email) {
        List<usuarioDTO> usuarios = usuarioService.getUsuariosByEmail(email);
        return new ResponseEntity<>(usuarios, HttpStatus.OK);
    }

    @GetMapping("/fecha-creacion")
    public ResponseEntity<List<usuarioDTO>> getUsuariosByFechaCreacionBetween(@RequestParam("start-date") LocalDateTime startDate, @RequestParam("end-date") LocalDateTime endDate) {
        List<usuarioDTO> usuarios = usuarioService.getUsuariosByFechaCreacionBetween(startDate, endDate);
        return new ResponseEntity<>(usuarios, HttpStatus.OK);
    }

    @GetMapping("/nombre-apellido/{nombre}/{apellido}")
    public ResponseEntity<List<usuarioDTO>> getUsuariosByNombreAndApellido(@PathVariable String nombre, @PathVariable String apellido) {
        List<usuarioDTO> usuarios = usuarioService.getUsuariosByNombreAndApellido(nombre, apellido);
        return new ResponseEntity<>(usuarios, HttpStatus.OK);
    }

    @GetMapping("/login")
    public ResponseEntity<usuarioDTO> getUsuarioByEmailAndPassword(@RequestParam("email") String email, @RequestParam("password") String password) {
        usuarioDTO usuario = usuarioService.getUsuarioByEmailAndPassword(email, password);
        return new ResponseEntity<>(usuario, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<usuarioDTO> saveUsuario(@RequestBody usuarioDTO usuarioDTO) {
        usuarioDTO usuario = usuarioService.saveUsuario(usuarioDTO);
        return new ResponseEntity<>(usuario, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUsuario(@PathVariable Long id) {
        usuarioService.deleteUsuario(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}