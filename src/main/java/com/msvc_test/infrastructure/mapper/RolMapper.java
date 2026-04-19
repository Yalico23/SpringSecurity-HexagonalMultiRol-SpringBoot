package com.msvc_test.infrastructure.mapper;

import com.msvc_test.domain.models.Rol;
import com.msvc_test.infrastructure.dto.request.RolDtoCreate;
import com.msvc_test.infrastructure.entities.RolEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface RolMapper {

    Rol toModel(RolEntity rolEntity);
    Rol toModel(RolDtoCreate rolDtoCreate);

    RolEntity toEntity(Rol rol);

    List<Rol> toModel(List<RolEntity> rolEntities);

    List<RolEntity> toEntity(List<Rol> rols);
}
