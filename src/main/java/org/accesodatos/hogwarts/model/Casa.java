package org.accesodatos.hogwarts.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "Casa")
public class Casa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_casa")
    private Long idCasa;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Column(nullable = false)
    private String fundador;

    @Column(nullable = false)
    private String fantasma;

    @ManyToOne
    @JoinColumn(name = "id_jefe")
    @JsonBackReference
    private Profesor jefe;

    @OneToMany(mappedBy = "casa")
    @JsonManagedReference
    private List<Student> estudiantes;
}
