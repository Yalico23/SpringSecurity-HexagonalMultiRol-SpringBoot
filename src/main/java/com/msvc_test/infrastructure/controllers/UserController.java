package com.msvc_test.infrastructure.controllers;

import com.msvc_test.application.service.AuthService;
import com.msvc_test.domain.models.User;
import com.msvc_test.infrastructure.configuration.auth.CustomUserDetails;
import com.msvc_test.infrastructure.dto.request.UserDtoCreate;
import com.msvc_test.infrastructure.mapper.UserMapper;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/users")
public class UserController {

    private final AuthService authService;
    private final UserMapper userMapper;

    @PostMapping
    public ResponseEntity<User> createUser(@Valid @RequestBody UserDtoCreate user){
        return ResponseEntity.status(HttpStatus.CREATED).body(authService.createUser(userMapper.toModel(user)));
    }

    @GetMapping("/me")
    public ResponseEntity<?> getCurrentUser(@AuthenticationPrincipal CustomUserDetails user){
        return ResponseEntity.ok(Map.of(
                "email", user.getUsername(),
                "id", user.getId()
        ));
    }

    // Ejemplo de endpoint protegido para crear un proyecto, solo accesible por usuarios con rol ADMIN NO ROLE_ADMIN
//    @PreAuthorize("hasAuthority('ADMIN')")
//    @PostMapping()
//    public ResponseEntity<Project> responseEntity(@RequestBody Project project){
//        return ResponseEntity.status(HttpStatus.CREATED).body(projectService.createProject(project));
//    }

}
