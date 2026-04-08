package com.msvc_test.domain.port.output;

import com.msvc_test.domain.models.Rol;
import com.msvc_test.domain.models.TypeRols;

import java.util.List;
import java.util.Optional;

public interface RolRepositoryPort {
    Rol save(Rol user);

    Optional<Rol> findById(String id);
    Optional<Rol> findByTypeRols(TypeRols typeRols);
    void deleteById(String id);
    List<Rol> findAll();
    boolean existsByTypeRols(TypeRols typeRols);
}
