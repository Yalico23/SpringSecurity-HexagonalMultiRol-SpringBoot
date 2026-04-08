package com.msvc_test.infrastructure.repositories;

import com.msvc_test.domain.models.Rol;
import com.msvc_test.domain.models.TypeRols;
import com.msvc_test.domain.port.output.RolRepositoryPort;
import com.msvc_test.infrastructure.mapper.RolMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RequiredArgsConstructor
@Component
public class RolEntityAdapter implements RolRepositoryPort {

    private final RolEntityRepository repository;
    private final RolMapper mapper;

    @Override
    public Rol save(Rol user) {
        return mapper.toModel(repository.save(mapper.toEntity(user)));
    }

    @Override
    public Optional<Rol> findById(String id) {
        return repository.findById(UUID.fromString(id))
                .map(mapper::toModel);
    }

    @Override
    public Optional<Rol> findByTypeRols(TypeRols typeRols) {
        return repository.findByTypeRols(typeRols)
                .map(mapper::toModel);
    }

    @Override
    public void deleteById(String id) {
        repository.deleteById(UUID.fromString(id));
    }

    @Override
    public List<Rol> findAll() {
        return mapper.toModel(repository.findAll());
    }

    @Override
    public boolean existsByTypeRols(TypeRols typeRols) {
        return repository.existsByTypeRols(typeRols);
    }
}
