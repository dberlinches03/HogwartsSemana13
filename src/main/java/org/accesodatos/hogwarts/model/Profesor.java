package org.accesodatos.hogwarts.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
@Entity
@Table(name = "Profesor")
public class Profesor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_profesor")
    private Long idProfesor;

    private String nombre;
    private String apellido;

    @Column(name = "fecha_inicio")
    private LocalDate fechaInicio;

    // N-1 con Asignatura
    @ManyToOne
    @JoinColumn(name = "id_asignatura")
    @JsonBackReference
    private Asignatura asignatura;

    // 1-N con Casa (jefe)
    @OneToMany(mappedBy = "jefe")
    @JsonManagedReference
    private List<Casa> casas;
}
