package org.accesodatos.hogwarts.controller.semana13;

import org.accesodatos.hogwarts.dto.response.MascotaDTO;
import org.accesodatos.hogwarts.service.MascotaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hogwarts/mascotas")
public class MascotaController {

    private final MascotaService service;

    public MascotaController(MascotaService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<MascotaDTO>> getAllMascotas() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<MascotaDTO> getMascotaById(@PathVariable Long id) {
        return service.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
