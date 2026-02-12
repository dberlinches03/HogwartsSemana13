package org.accesodatos.hogwarts.dto.request.create;

import lombok.Data;

import java.time.LocalDate;

@Data
public class EstudianteCreateDTO {

    private String nombre;
    private String apellido;
    private int anyoCurso;
    private LocalDate fechaNacimiento;
    private Long casaId;
    private MascotaCreateDTO mascota;
}
