    package com.generation.redsocialmypets.Models;

    import jakarta.persistence.*;
    import lombok.*;


    @Entity
    @Table(name = "usuarios")
    @Data
    @Builder//Método Builder que nos da otra sintaxis para la construcción del objeto
    public class Usuario {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        private String nombre;
        private String apellido;
        private String email;
        private String password;

        @ManyToOne
        @JoinColumn(name = "rol_id")
        private Rol rolUsuario;

        public Usuario() {

        }

    }

