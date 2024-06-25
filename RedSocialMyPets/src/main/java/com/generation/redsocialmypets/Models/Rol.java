package com.generation.redsocialmypets.Models;


import aj.org.objectweb.asm.commons.Remapper;
import jakarta.persistence.*;
import lombok.*;

import java.nio.file.FileStore;

@Entity
@Table(name = "roles")
@Data
@Getter
@Setter
public class Rol {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    //Mapea un tipo enumerado(enum) a una columna de la base de datos para la tabla rol
    @Enumerated(EnumType.STRING)
    @Column(name = "nombre_rol")
    private ERol nombreRol;

    public Remapper stream() {
        return null;
    }

    public FileStore getNombre() {
        return getNombre();
    }
}
