package com.generation.redsocialmypets.DTO;


import lombok.Data;
import jakarta.validation.constraints.*;

import java.time.LocalDateTime;

@Data
public class mascotaDTO {

    @NotBlank(message = "El nombre no puede estar en blanco")
    @Size(min = 1, max = 20, message = "El nombre debe tener entre 1 y 20 caracteres")
    private String nombre;

    @NotBlank(message = "La especie no puede estar en blanco")
    @Size(min = 1, max = 20, message = "La especie debe tener entre 1 y 20 caracteres")
    private String especie;

    @NotBlank(message = "La raza no puede estar en blanco")
    @Size(min = 1, max = 20, message = "La raza debe tener entre 1 y 20 caracteres")
    private String raza;

    @NotNull(message = "La fecha de nacimiento no puede ser nula")
    private LocalDateTime fechaNacimiento;
}
