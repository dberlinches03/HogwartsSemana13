package org.accesodatos.hogwarts.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "Asignatura")
public class Asignatura {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_asignatura") private Long idAsignatura;
    @Column(name = "nombre", nullable = false)
    private String nombre;

    private String aula;

    private Boolean obligatoria;

    @OneToMany(mappedBy = "asignatura")
    @JsonManagedReference
    private List<Profesor> profesores;

    @OneToMany(mappedBy = "asignatura")
    @JsonManagedReference
    private List<EstudianteAsignatura> estudianteAsignaturas;
}
