package com.generation.redsocialmypets.security;

import com.generation.redsocialmypets.Models.Usuario;
import com.generation.redsocialmypets.Repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UsuarioRepository usuarioRepository;


    @Override
    public UserDetails loadUserByUsername(String nombre) throws UsernameNotFoundException {
        List<Usuario> usuarios = usuarioRepository.findByNombre(nombre  );
        Usuario usuario = usuarios.stream().findFirst()
                .orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado"));
        return new CustomUserDetails(usuario);
    }
}