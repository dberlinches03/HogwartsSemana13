package org.accesodatos.hogwarts.controller;

import org.accesodatos.hogwarts.dto.request.create.EstudianteCreateDTO;
import org.accesodatos.hogwarts.dto.request.update.EstudianteUpdateDTO;
import org.accesodatos.hogwarts.dto.response.EstudianteDTO;
import org.accesodatos.hogwarts.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/estudiantes")
public class StudentController {
    private final StudentService service;
    public StudentController(StudentService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<EstudianteDTO> create(@RequestBody EstudianteCreateDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(dto));
    }
    @PutMapping("/{id}")
    public ResponseEntity<EstudianteDTO> update(@PathVariable Long id, @RequestBody EstudianteUpdateDTO dto) {
        return ResponseEntity.ok(service.update(id, dto));
    }
}
