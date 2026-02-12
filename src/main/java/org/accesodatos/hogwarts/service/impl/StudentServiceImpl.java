package org.accesodatos.hogwarts.service.impl;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.Data;
import org.accesodatos.hogwarts.dto.request.create.EstudianteCreateDTO;
import org.accesodatos.hogwarts.dto.request.update.EstudianteUpdateDTO;
import org.accesodatos.hogwarts.dto.response.EstudianteDTO;
import org.accesodatos.hogwarts.mapper.EstudianteMapper;
import org.accesodatos.hogwarts.model.Casa;
import org.accesodatos.hogwarts.model.Mascota;
import org.accesodatos.hogwarts.model.Student;
import org.accesodatos.hogwarts.repository.CasaRepository;
import org.accesodatos.hogwarts.repository.MascotaRepository;
import org.accesodatos.hogwarts.repository.StudentRepository;
import org.accesodatos.hogwarts.service.StudentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Data
@Service
public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;
    private final CasaRepository casaRepository;
    private final MascotaRepository mascotaRepository;
    private final EstudianteMapper mapper = new EstudianteMapper();


    @Override
    @Transactional
    public List<EstudianteDTO> findAll() {
        return studentRepository.findAll()
                .stream()
                .map(mapper::toDTO)
                .toList();
    }

    @Override
    @Transactional
    public EstudianteDTO findById(Long id) {
        Student estudiante = studentRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Estudiante no encontrado con id: " + id));
        return mapper.toDTO(estudiante);
    }

    @Override
    @Transactional
    public EstudianteDTO create(EstudianteCreateDTO dto) {
        Casa casa = casaRepository.findById(dto.getCasaId())
                .orElseThrow(() -> new IllegalArgumentException("Casa no encontrada"));
        Student estudiante = mapper.toEntity(dto, casa);
        estudiante = studentRepository.save(estudiante);

        if (dto.getMascota() != null) {
            Mascota mascota = mapper.toMascotaEntity(dto.getMascota(), estudiante);
            mascota = mascotaRepository.save(mascota);
            estudiante.setMascota(mascota);
            estudiante = studentRepository.save(estudiante);
        }
        return mapper.toDTO(estudiante);
    }
    @Override
    @Transactional
    public EstudianteDTO update(Long id, EstudianteUpdateDTO dto) {
        Student estudiante = studentRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Estudiante no encontrado"));


        mapper.updateEntity(estudiante, dto);

        if (dto.getMascota() == null) {
            estudiante.setMascota(null);
        } else if (estudiante.getMascota() == null) {
            Mascota nueva = mapper.toMascotaEntity(dto.getMascota(), estudiante);
            estudiante.setMascota(nueva);
        } else {
            mapper.updateMascota(estudiante.getMascota(), dto.getMascota());
        }

        studentRepository.save(estudiante);
        return mapper.toDTO(estudiante);
    }

    @Override
    @Transactional
    public void eliminarEstudiante(Long id) {
        Student estudiante = studentRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Estudiante no encontrado con id: " + id));

        // Si tiene mascota, la eliminamos también (Soft Delete)
        if (estudiante.getMascota() != null) {
            mascotaRepository.delete(estudiante.getMascota());
        }

        studentRepository.delete(estudiante); // Soft Delete
    }
}
