package com.msvc_test.infrastructure.configuration;

import com.msvc_test.application.service.AuthService;
import com.msvc_test.application.usecases.CreateRolUseCaseImpl;
import com.msvc_test.application.usecases.CreateUserUseCaseImpl;
import com.msvc_test.application.usecases.ListInformationUseCaseImpl;
import com.msvc_test.domain.port.output.RolRepositoryPort;
import com.msvc_test.domain.port.output.UserRepositoryPort;
import com.msvc_test.infrastructure.configuration.auth.utils.SecurityUtils;
import com.msvc_test.infrastructure.repositories.RolEntityAdapter;
import com.msvc_test.infrastructure.repositories.UserEntityAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class ApplicationConfig {

    @Bean
    public AuthService authService(RolRepositoryPort rolRepositoryPort, UserRepositoryPort userRepositoryPort, PasswordEncoder passwordEncoder, SecurityUtils utils) {

        return new AuthService(
                new CreateUserUseCaseImpl(userRepositoryPort,rolRepositoryPort,passwordEncoder),
                new CreateRolUseCaseImpl(rolRepositoryPort),
                new ListInformationUseCaseImpl(utils, userRepositoryPort));
    }

    @Bean
    public RolRepositoryPort rolRepositoryPort(RolEntityAdapter rolRepositoryAdapter) {
        return rolRepositoryAdapter;
    }

    @Bean
    public UserRepositoryPort userRepositoryPort(UserEntityAdapter userEntityAdapter) {
        return userEntityAdapter;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(); // Utiliza BCrypt para el hashing de contraseñas, lo que proporciona una seguridad robusta para las contraseñas almacenadas en la base de datos.
    }
}
