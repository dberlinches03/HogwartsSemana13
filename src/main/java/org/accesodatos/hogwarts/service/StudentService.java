package org.accesodatos.hogwarts.service;

import org.accesodatos.hogwarts.dto.request.create.EstudianteCreateDTO;
import org.accesodatos.hogwarts.dto.request.update.EstudianteUpdateDTO;
import org.accesodatos.hogwarts.dto.response.EstudianteDTO;

public interface StudentService {

    EstudianteDTO create(EstudianteCreateDTO estudianteDTO);
    EstudianteDTO update(Long id, EstudianteUpdateDTO dto);
}