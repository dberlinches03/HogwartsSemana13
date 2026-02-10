package org.accesodatos.hogwarts.dto.request.update;

import lombok.Data;

import java.time.LocalDate;

@Data
public class EstudianteUpdateDTO {
    private int anyoCurso;
    private LocalDate fechaNacimiento;
    private MascotaUpdateDTO mascota;
}
