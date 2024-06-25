package com.generation.redsocialmypets.DTO;


import lombok.Data;
import jakarta.validation.constraints.*;


@Data
    public class usuarioDTO {


        @NotBlank(message = "El nombre no puede estar en blanco")
        @Size(min = 1, max = 50, message = "El nombre debe tener entre 1 y 50 caracteres")
        private String nombre;

        @NotBlank(message = "El apellido no puede estar en blanco")
        @Size(min = 1, max = 50, message = "El apellido debe tener entre 1 y 50 caracteres")
        private String apellido;

        @NotBlank(message = "El email no puede estar en blanco")
        @Size(min = 5, max = 100, message = "El email debe tener entre 5 y 100 caracteres")
        @Pattern(regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$", message = "El correo electrónico no es válido")
        private String email;

        @NotBlank(message = "La contraseña no puede estar en blanco")
        @Size(min = 8, max = 40, message = "La contraseña debe tener entre 8 y 40 caracteres")
        @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,128}$",
        message = "La contraseña debe contener al menos una letra minúscula, una letra mayúscula, un número y un carácter especial")
        private String password;


}

