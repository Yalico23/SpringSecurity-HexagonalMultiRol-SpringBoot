package com.msvc_test.infrastructure.repositories;

import com.msvc_test.domain.models.TypeRols;
import com.msvc_test.infrastructure.entities.RolEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface RolEntityRepository extends JpaRepository<RolEntity, UUID> {
    boolean existsByTypeRols(TypeRols typeRols);
    Optional<RolEntity> findByTypeRols(TypeRols typeRols);
}