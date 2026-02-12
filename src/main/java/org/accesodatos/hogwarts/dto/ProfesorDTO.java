package org.accesodatos.hogwarts.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class ProfesorDTO {

    private Long id;
    private String nombre;      // nombre + apellido
    private String asignatura;  // nombre asignatura
    private LocalDate fechaInicio;

}
