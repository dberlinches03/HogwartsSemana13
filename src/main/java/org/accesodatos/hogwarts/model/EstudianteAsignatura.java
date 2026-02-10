package org.accesodatos.hogwarts.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "estudiante_asignatura")
public class EstudianteAsignatura {

    @EmbeddedId
    private EstudianteAsignaturaId id;

    @ManyToOne
    @MapsId("idEstudiante")
    @JoinColumn(name = "id_estudiante")
    @JsonBackReference
    private Student estudiante;

    @ManyToOne
    @MapsId("idAsignatura")
    @JoinColumn(name = "id_asignatura")
    @JsonBackReference
    private Asignatura asignatura;

    private Double calificacion;
}
