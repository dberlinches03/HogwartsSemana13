package org.accesodatos.hogwarts.controller.semana13;

import org.accesodatos.hogwarts.dto.CasaDTO;
import org.accesodatos.hogwarts.service.CasaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hogwarts/casas")
public class CasaController {

    private final CasaService service;

    public CasaController(CasaService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<CasaDTO>> getAllCasas() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CasaDTO> getCasaById(@PathVariable Long id) {
        return service.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
