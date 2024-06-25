package com.generation.redsocialmypets.Models;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;


@Entity
@Table(name= "likes")
public class Like {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @CreationTimestamp
    private LocalDateTime fechaLike;
    @ManyToOne
    @JoinColumn(name = "publicacion_id")
    private Publicacion publicacion;
    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    public Like() {
    }

    public Like(Long id, LocalDateTime fechaLike, Publicacion publicacion, Usuario usuario) {
        this.id = id;
        this.fechaLike = fechaLike;
        this.publicacion = publicacion;
        this.usuario = usuario;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getFechaLike() {
        return fechaLike;
    }

    public void setFechaLike(LocalDateTime fechaLike) {
        this.fechaLike = fechaLike;
    }

    public Publicacion getPublicacion() {
        return publicacion;
    }

    public void setPublicacion(Publicacion publicacion) {
        this.publicacion = publicacion;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}