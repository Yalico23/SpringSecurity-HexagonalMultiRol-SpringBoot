package com.msvc_test.application.service;

import com.msvc_test.domain.models.Rol;
import com.msvc_test.domain.models.User;
import com.msvc_test.domain.port.input.CreateRolUseCase;
import com.msvc_test.domain.port.input.CreateUserUseCase;
import com.msvc_test.domain.port.input.ListInformationUseCase;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AuthService implements CreateUserUseCase, CreateRolUseCase, ListInformationUseCase {

    private final CreateUserUseCase createUserUseCase;
    private final CreateRolUseCase createRolUseCase;
    private final ListInformationUseCase listInformationUseCase;

    public AuthService(CreateUserUseCase createUserUseCase, CreateRolUseCase createRolUseCase, ListInformationUseCase listInformationUseCase) {
        this.createUserUseCase = createUserUseCase;
        this.createRolUseCase = createRolUseCase;
        this.listInformationUseCase = listInformationUseCase;
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

    @Transactional(readOnly = true)
    @Override
    public User userInformation() {
        return listInformationUseCase.userInformation();
    }
}
