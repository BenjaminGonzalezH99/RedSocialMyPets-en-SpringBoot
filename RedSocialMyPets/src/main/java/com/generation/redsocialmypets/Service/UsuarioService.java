package com.generation.redsocialmypets.Service;

import com.generation.redsocialmypets.DTO.usuarioDTO;
import com.generation.redsocialmypets.Models.Usuario;
import com.generation.redsocialmypets.Repository.UsuarioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<usuarioDTO> getUsuarios() {
        List<Usuario> usuarios = usuarioRepository.findAll();
        return usuarios.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public List<usuarioDTO> getUsuariosByNombre(String nombre) {
        List<Usuario> usuarios = usuarioRepository.findByNombre(nombre);
        return usuarios.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public List<usuarioDTO> getUsuariosByApellido(String apellido) {
        List<Usuario> usuarios = usuarioRepository.findByApellidoContaining(apellido);
        return usuarios.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public List<usuarioDTO> getUsuariosByEmail(String email) {
        List<Usuario> usuarios = usuarioRepository.findByEmailContaining(email);
        return usuarios.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public List<usuarioDTO> getUsuariosByFechaCreacionBetween(LocalDateTime startDate, LocalDateTime endDate) {
        List<Usuario> usuarios = usuarioRepository.findByFechaCreacionBetween(startDate, endDate);
        return usuarios.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public List<usuarioDTO> getUsuariosByNombreAndApellido(String nombre, String apellido) {
        List<Usuario> usuarios = usuarioRepository.findByNombreAndApellido(nombre, apellido);
        return usuarios.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public usuarioDTO getUsuarioByEmailAndPassword(String email, String password) {
        Usuario usuario = usuarioRepository.findByEmailAndPassword(email, password);
        return convertToDTO(usuario);
    }

    public usuarioDTO saveUsuario(usuarioDTO usuarioDTO) {
        Usuario usuario = convertToEntity(usuarioDTO);
        usuario = usuarioRepository.save(usuario);
        return convertToDTO(usuario);
    }

    public void deleteUsuario(Long id) {
        usuarioRepository.deleteById(id);
    }

    private usuarioDTO convertToDTO(Usuario usuario) {
        usuarioDTO dto = new usuarioDTO();
        dto.setNombre(usuario.getNombre());
        dto.setApellido(usuario.getApellido());
        dto.setEmail(usuario.getEmail());
        dto.setPassword(usuario.getPassword());
        return dto;
    }

    private Usuario convertToEntity(usuarioDTO usuarioDTO) {
        Usuario usuario = new Usuario();
        usuario.setNombre(usuarioDTO.getNombre());
        usuario.setApellido(usuarioDTO.getApellido());
        usuario.setEmail(usuarioDTO.getEmail());
        usuario.setPassword(usuarioDTO.getPassword());
        return usuario;
    }
}