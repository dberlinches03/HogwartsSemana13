package org.accesodatos.hogwarts.service;

import org.accesodatos.hogwarts.dto.request.create.EstudianteCreateDTO;
import org.accesodatos.hogwarts.dto.request.update.EstudianteUpdateDTO;
import org.accesodatos.hogwarts.dto.response.EstudianteDTO;

import java.util.List;

public interface StudentService {

    List<EstudianteDTO> findAll();
    EstudianteDTO create(EstudianteCreateDTO estudianteDTO);
    EstudianteDTO update(Long id, EstudianteUpdateDTO dto);
    void eliminarEstudiante(Long id);
    EstudianteDTO findById(Long id);
}