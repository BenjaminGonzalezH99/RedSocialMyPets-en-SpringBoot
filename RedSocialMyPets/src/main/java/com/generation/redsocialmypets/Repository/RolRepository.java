package com.generation.redsocialmypets.Repository;

import com.generation.redsocialmypets.Models.ERol;
import com.generation.redsocialmypets.Models.Rol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


    @Repository
    public interface RolRepository extends JpaRepository<Rol, Long> {

        Rol findRolByNombreRol(ERol nombreRol);
    }


