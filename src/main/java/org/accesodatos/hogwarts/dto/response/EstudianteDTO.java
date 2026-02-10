package org.accesodatos.hogwarts.dto.response;

import lombok.Data;
import org.accesodatos.hogwarts.dto.AsignaturaCalificacionDTO;

import java.time.LocalDate;
import java.util.List;

@Data
public class EstudianteDTO {

    private Long id;
    private String nombre;
    private String apellido;
    private int anyoCurso;
    private LocalDate fechaNacimiento;
    private String casa;
    private MascotaDTO mascota;
    private List<AsignaturaCalificacionDTO> asignaturas;
}
