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

    @GetMapping
    public ResponseEntity<List<EstudianteDTO>> findAll() {
        return ResponseEntity.ok(service.findAll()); // 200
    }

    @GetMapping("/{id}")
    public ResponseEntity<EstudianteDTO> findById(@PathVariable Long id) {
        return ResponseEntity.ok(service.findById(id)); // 200
    }
    @PostMapping
    public ResponseEntity<EstudianteDTO> create(@RequestBody EstudianteCreateDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(dto));
    }
    @PutMapping("/{id}")
    public ResponseEntity<EstudianteDTO> update(@PathVariable Long id, @RequestBody EstudianteUpdateDTO dto) {
        return ResponseEntity.ok(service.update(id, dto));
    }

    // "Borrado"
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarEstudiante(@PathVariable Long id) {
        service.eliminarEstudiante(id);
        return ResponseEntity.noContent().build(); // 204 No Content
    }
}
