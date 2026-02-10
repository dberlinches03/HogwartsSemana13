package org.accesodatos.hogwarts.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "Mascota")
public class Mascota {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_mascota")
    private Long idMascota;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Column(nullable = false)
    private String especie;

    @OneToOne(optional = true)
    @JoinColumn(name = "id_estudiante")
    @JsonBackReference
    private Student estudiante;
}
