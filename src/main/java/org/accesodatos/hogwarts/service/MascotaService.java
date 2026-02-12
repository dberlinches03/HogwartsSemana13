package org.accesodatos.hogwarts.service;

import org.accesodatos.hogwarts.dto.response.MascotaDTO;
import org.accesodatos.hogwarts.mapper.MascotaMapper;
import org.accesodatos.hogwarts.repository.MascotaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MascotaService {

    private final MascotaRepository repo;

    public MascotaService(MascotaRepository repo) {
        this.repo = repo;
    }

    public List<MascotaDTO> findAll() {
        return repo.findAll()
                .stream()
                .map(MascotaMapper::toDto)
                .collect(Collectors.toList());
    }

    public Optional<MascotaDTO> findById(Long id) {
        return repo.findById(id)
                .map(MascotaMapper::toDto);
    }
}
