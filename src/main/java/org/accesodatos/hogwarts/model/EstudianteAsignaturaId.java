package org.accesodatos.hogwarts.model;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.Objects;

@Data
@Embeddable
public class EstudianteAsignaturaId implements Serializable {

    @Column(name = "id_estudiante")
    private Long idEstudiante;

    @Column(name = "id_asignatura")
    private Long idAsignatura;

    public EstudianteAsignaturaId() {}

    public EstudianteAsignaturaId(Long idEstudiante, Long idAsignatura) {
        this.idEstudiante = idEstudiante;
        this.idAsignatura = idAsignatura;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof EstudianteAsignaturaId that)) return false;
        return Objects.equals(idEstudiante, that.idEstudiante)
                && Objects.equals(idAsignatura, that.idAsignatura);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idEstudiante, idAsignatura);
    }
}
