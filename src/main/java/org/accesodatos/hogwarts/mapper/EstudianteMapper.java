package org.accesodatos.hogwarts.mapper;

import org.accesodatos.hogwarts.dto.AsignaturaCalificacionDTO;
import org.accesodatos.hogwarts.dto.request.create.EstudianteCreateDTO;
import org.accesodatos.hogwarts.dto.request.create.MascotaCreateDTO;
import org.accesodatos.hogwarts.dto.request.update.EstudianteUpdateDTO;
import org.accesodatos.hogwarts.dto.request.update.MascotaUpdateDTO;
import org.accesodatos.hogwarts.dto.response.EstudianteDTO;
import org.accesodatos.hogwarts.dto.response.MascotaDTO;
import org.accesodatos.hogwarts.model.Casa;
import org.accesodatos.hogwarts.model.Mascota;
import org.accesodatos.hogwarts.model.Student;

import java.util.List;
import java.util.stream.Collectors;

public class EstudianteMapper {

    public EstudianteDTO toDTO(Student estudiante) {
        EstudianteDTO dto = new EstudianteDTO();
        dto.setId(estudiante.getIdEstudiante());
        dto.setNombre(estudiante.getNombre());
        dto.setApellido(estudiante.getApellido());
        dto.setAnyoCurso(estudiante.getAnyoCurso());
        dto.setFechaNacimiento(estudiante.getFechaNacimiento());
        dto.setCasa(estudiante.getCasa().getNombre());

        // Mascota puede ser null
        if (estudiante.getMascota() != null) {
            Mascota mascota = estudiante.getMascota();
            MascotaDTO mascotaDTO = new MascotaDTO();
            mascotaDTO.setId(mascota.getIdMascota());
            mascotaDTO.setNombre(mascota.getNombre());
            mascotaDTO.setEspecie(mascota.getEspecie());
            mascotaDTO.setEstudiante(estudiante.getNombre() + " " + estudiante.getApellido());
            dto.setMascota(mascotaDTO);
        } else {
            dto.setMascota(null);
        }

        return dto;
    }


    public Student toEntity(EstudianteCreateDTO dto, Casa casa) {
        Student estudiante = new Student();
        estudiante.setNombre(dto.getNombre());
        estudiante.setApellido(dto.getApellido());
        estudiante.setAnyoCurso(dto.getAnyoCurso());
        estudiante.setFechaNacimiento(dto.getFechaNacimiento());
        estudiante.setCasa(casa);
        return estudiante;
    }

    // Para actualizar
    public Mascota toMascotaEntity(MascotaUpdateDTO dto, Student estudiante) {
        Mascota mascota = new Mascota();
        mascota.setNombre(dto.getNombre());
        mascota.setEspecie(dto.getEspecie());
        mascota.setEstudiante(estudiante);
        return mascota;
    }


    // Para crear
    public Mascota toMascotaEntity(MascotaCreateDTO dto, Student estudiante) {
        Mascota mascota = new Mascota();
        mascota.setNombre(dto.getNombre());
        mascota.setEspecie(dto.getEspecie());
        mascota.setEstudiante(estudiante);
        return mascota;
    }
    public void updateEntity(Student estudiante, EstudianteUpdateDTO dto) {
        estudiante.setAnyoCurso(dto.getAnyoCurso());
        estudiante.setFechaNacimiento(dto.getFechaNacimiento());
    }
    public void updateMascota(Mascota mascota, MascotaUpdateDTO dto) {
        mascota.setNombre(dto.getNombre());
        mascota.setEspecie(dto.getEspecie());
    }
}
