package org.accesodatos.hogwarts.controller.semana13;

import org.accesodatos.hogwarts.dto.AsignaturaDTO;
import org.accesodatos.hogwarts.service.AsignaturaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hogwarts/asignaturas")
public class AsignaturaController {

    private final AsignaturaService service;

    public AsignaturaController(AsignaturaService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<AsignaturaDTO>> getAllAsignaturas() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<AsignaturaDTO> getAsignaturaById(@PathVariable Long id) {
        return service.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}