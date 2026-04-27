package com.msvc_test.application.usecases;

import com.msvc_test.domain.exceptions.UserNotFoundException;
import com.msvc_test.domain.models.User;
import com.msvc_test.domain.port.input.ListInformationUseCase;
import com.msvc_test.domain.port.output.UserRepositoryPort;
import com.msvc_test.infrastructure.configuration.auth.utils.SecurityUtils;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ListInformationUseCaseImpl implements ListInformationUseCase {

    private final SecurityUtils securityUtils;
    private final UserRepositoryPort userRepositoryPort;

    @Override
    public User userInformation() {
        String userId = String.valueOf(securityUtils.getCurrentUserId());
        return userRepositoryPort.findById(userId).orElseThrow(()-> new UserNotFoundException("User not found with id: " + userId));
    }
}
