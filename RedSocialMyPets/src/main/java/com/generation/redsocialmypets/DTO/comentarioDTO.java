package com.generation.redsocialmypets.DTO;

import lombok.Data;
import jakarta.validation.constraints.*;



@Data
public class comentarioDTO {
    @NotBlank(message = "El texto del comentario no puede estar en blanco")
    @Size(min = 1, max = 200, message = "El texto del comentario debe tener entre 1 y 200 caracteres")
    private String texto;
   }
