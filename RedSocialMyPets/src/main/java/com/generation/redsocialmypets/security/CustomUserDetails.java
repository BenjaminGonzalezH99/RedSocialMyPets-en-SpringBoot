package com.generation.redsocialmypets.security;

import com.generation.redsocialmypets.Models.Rol;
import com.generation.redsocialmypets.Models.Usuario;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

public class CustomUserDetails implements UserDetails {

    private String username;
    private String password;
    private Collection<? extends GrantedAuthority> authorities;

    public CustomUserDetails(Usuario usuario) {
        this.username = usuario.getNombre();
        this.password = usuario.getPassword();
        this.authorities = getAuthoritiesFromRoles(usuario.getRolUsuario());
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    private Collection<? extends GrantedAuthority> getAuthoritiesFromRoles(Rol rolUsuario) {
        // Implementar lógica para obtener los roles del usuario
        // y convertirlos en objetos GrantedAuthority}
        return java.util.List.of();
    }

}