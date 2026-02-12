package org.accesodatos.hogwarts.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.SoftDelete;

import java.time.LocalDate;
import java.util.List;

@SoftDelete
@Data
@Entity
@Table(name = "Estudiante")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_estudiante")
    private Long idEstudiante;

    private String nombre;
    private String apellido;

    @Column(name = "anyo_curso")
    private int anyoCurso;

    @Column(name = "fecha_nacimiento")
    private LocalDate fechaNacimiento;

    // ManyToOne con Casa
    @ManyToOne
    @JoinColumn(name = "id_casa")
    @JsonBackReference
    private Casa casa;

    // OneToOne con Mascota
    @OneToOne(mappedBy = "estudiante", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    @JsonManagedReference
    private Mascota mascota;

    // N-N con Asignatura mediante EstudianteAsignatura
    @OneToMany(mappedBy = "estudiante")
    @JsonManagedReference
    private List<EstudianteAsignatura> estudianteAsignaturas;
}
