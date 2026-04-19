package com.msvc_test.infrastructure.entities;

import com.fasterxml.jackson.databind.annotation.EnumNaming;
import com.msvc_test.domain.models.TypeRols;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.UuidGenerator;

import java.util.UUID;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "rols")
public class RolEntity {
    @Id
    @GeneratedValue
    @UuidGenerator
    @Column(name = "id", updatable = false, nullable = false)
    private UUID id;
    @Enumerated(EnumType.STRING)
    @Column(name = "type_rols", nullable = false)
    private TypeRols typeRols;
}
