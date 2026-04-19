package com.msvc_test.infrastructure.mapper;

import com.msvc_test.domain.models.User;
import com.msvc_test.infrastructure.dto.request.UserDtoCreate;
import com.msvc_test.infrastructure.entities.UserEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {

    User toModel(UserEntity userEntity);
    User toModel(UserDtoCreate userDtoCreate);

    UserEntity toEntity(User user);

    List<User> toModel(List<UserEntity> userEntities);

    List<UserEntity> toEntity(List<User> users);

}
