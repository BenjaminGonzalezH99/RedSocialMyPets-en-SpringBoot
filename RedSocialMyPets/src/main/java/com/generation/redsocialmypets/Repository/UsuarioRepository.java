package com.generation.redsocialmypets.Repository;

import com.generation.redsocialmypets.Models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    // Búsqueda por nombre
    @Query("SELECT u FROM Usuario u WHERE u.nombre LIKE %:nombre%")
    List<Usuario> findByNombre(String nombre);

    // Búsqueda por apellido
    @Query("SELECT u FROM Usuario u WHERE u.apellido LIKE %:apellido%")
    List<Usuario> findByApellidoContaining(String apellido);

    // Búsqueda por email
    @Query("SELECT u FROM Usuario u WHERE u.email LIKE %:email%")
    List<Usuario> findByEmailContaining(String email);

    // Búsqueda por fecha de creación
    @Query("SELECT u FROM Usuario u WHERE u.fechaCreacion BETWEEN :startDate AND :endDate")
    List<Usuario> findByFechaCreacionBetween(@Param("startDate") LocalDateTime startDate, @Param("endDate") LocalDateTime endDate);

    // Búsqueda por nombre y apellido
    @Query("SELECT u FROM Usuario u WHERE u.nombre LIKE %:nombre% AND u.apellido LIKE %:apellido%")
    List<Usuario> findByNombreAndApellido(String nombre, String apellido);

    // Búsqueda por email y contraseña
    @Query("SELECT u FROM Usuario u WHERE u.email = :email AND u.password = :password")
    Usuario findByEmailAndPassword(String email, String password);
}