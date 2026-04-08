package com.msvc_test.application.service;

import com.msvc_test.domain.models.Rol;
import com.msvc_test.domain.models.User;
import com.msvc_test.domain.port.input.CreateRolUseCase;
import com.msvc_test.domain.port.input.CreateUserUseCase;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class AuthService implements CreateUserUseCase, CreateRolUseCase {

    private final CreateUserUseCase createUserUseCase;
    private final CreateRolUseCase createRolUseCase;

    public AuthService(CreateUserUseCase createUserUseCase, CreateRolUseCase createRolUseCase) {
        this.createUserUseCase = createUserUseCase;
        this.createRolUseCase = createRolUseCase;
    }

    @Transactional
    @Override
    public Rol createRol(Rol rol) {
        return createRolUseCase.createRol(rol);
    }

    @Transactional
    @Override
    public User createUser(User user) {
        return createUserUseCase.createUser(user);
    }
}
