package org.accesodatos.hogwarts.dto.response;

import lombok.Data;

@Data
public class MascotaDTO {

    private Long id;
    private String nombre;
    private String especie;
    private String estudiante; // nombre completo
}
